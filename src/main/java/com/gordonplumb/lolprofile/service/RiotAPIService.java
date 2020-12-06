package com.gordonplumb.lolprofile.service;

import com.gordonplumb.lolprofile.model.*;
import com.gordonplumb.lolprofile.repository.AccountMatchReferenceRepository;
import com.gordonplumb.lolprofile.repository.MatchDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@ConfigurationProperties(prefix = "riot")
@Service
public class RiotAPIService {
    @Autowired
    private AccountMatchReferenceRepository accountMatchReferenceRepository;

    @Autowired
    private MatchDataRepository matchDataRepository;

    private String apiKey = System.getenv("RIOT_API_KEY");
    private Logger logger = LoggerFactory.getLogger(RiotAPIService.class);

    private WebClient client = WebClient.builder().baseUrl("https://na1.api.riotgames.com").defaultHeader("X-Riot-Token", apiKey).build();

    private final int SUMMONERS_RIFT_DRAFT = 400;
    private final int SUMMONERS_RIFT_RANKED_SOLO = 420;
    private final int SUMMONERS_RIFT_BLIND = 430;
    private final int SUMMONERS_RIFT_FLEX = 440;
    private final int SUMMONERS_RIFT_CLASH = 700;
    private final Set<Integer> QUEUES = Set.of(
            SUMMONERS_RIFT_DRAFT,
            SUMMONERS_RIFT_RANKED_SOLO,
            SUMMONERS_RIFT_BLIND,
            SUMMONERS_RIFT_FLEX,
            SUMMONERS_RIFT_CLASH
    );

    public Account getAccount(String name) {
        logger.debug("getAccount: " + name);
        return client.get()
                .uri("/lol/summoner/v4/summoners/by-name/" + name)
                .retrieve()
                .bodyToMono(Account.class)
                .block();
    }

    public List<AccountMatchReference> getMatches(String encryptedAccountId) {
        logger.debug("getMatches: " + encryptedAccountId);
        MatchList matchList =  client.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/lol/match/v4/matchlists/by-account/" + encryptedAccountId)
                        .queryParam("queue", QUEUES)
                        .build())
                .retrieve()
                .bodyToMono(MatchList.class)
                .block();

        if (matchList != null) {
            List<AccountMatchReference> accountMatches = matchList.getMatches().stream().map(match -> {
                AccountMatchReference matchReference = new AccountMatchReference(encryptedAccountId, match.getGameId(), match.getRole(), match.getChampion(), match.getQueue(), match.getLane(), match.getTimestamp());
                accountMatchReferenceRepository.save(matchReference);
                return matchReference;
            }).collect(Collectors.toList());

            List<Long> matchIds = matchList.getMatches().stream().map(MatchReference::getGameId).collect(Collectors.toList());
            getAllMatchData(matchIds).subscribe(match -> {
                // find the participant dto of the player
                Participant participant = null;
                List<ParticipantIdentity> participantIdentities = match.getParticipantIdentities();
                List<Participant> participants = match.getParticipants();
                for (int i = 0; i < 10; i++) {
                    ParticipantIdentity participantIdentity = participantIdentities.get(i);
                    if (participantIdentity.getPlayer().getCurrentAccountId().equals(encryptedAccountId)) {
                        participant = participants.get(i);
                        break;
                    }
                }

                if (participant != null) {
                    ParticipantStats participantStats = participant.getStats();
                    MatchData matchData = new MatchData(encryptedAccountId, match.getGameId(), participantStats);
                    matchDataRepository.save(matchData);
                }
            });
            return accountMatches;
        }

        return new ArrayList<>();
    }

    private Flux<Match> getAllMatchData(List<Long> matchIds) {
        logger.debug("getAllMatchData");
        return Flux.fromIterable(matchIds)
                .delayElements(Duration.ofMillis(200))
                .parallel()
                .runOn(Schedulers.boundedElastic())
                .flatMap(this::getMatchData)
                .sequential();
    }

    private Mono<Match> getMatchData(long matchId) {
        logger.debug("getMatchData: " + matchId);
        return client.get()
                .uri("/lol/match/v4/matches/" + matchId)
                .retrieve()
                .bodyToMono(Match.class);
    }
}
