package com.gordonplumb.lolprofile.service;

import com.gordonplumb.lolprofile.model.*;
import com.gordonplumb.lolprofile.repository.AccountMatchDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@ConfigurationProperties(prefix = "riot")
@Service
public class RiotAPIService {
    @Autowired
    private AccountMatchDataRepository accountMatchDataRepository;

    private String apiKey = System.getenv("RIOT_API_KEY");
    private Logger logger = LoggerFactory.getLogger(RiotAPIService.class);

    private WebClient client = WebClient.builder()
            .baseUrl("https://na1.api.riotgames.com")
            .defaultHeader("X-Riot-Token", apiKey)
            .build();

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

    public List<AccountMatchData> getMatches(String encryptedAccountId) {
        logger.debug("getMatches: " + encryptedAccountId);
        MatchList matchList = client.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/lol/match/v4/matchlists/by-account/" + encryptedAccountId)
                        .queryParam("queue", QUEUES)
                        .build())
                .retrieve()
                .bodyToMono(MatchList.class)
                .block();

        if (matchList != null) {
            List<MatchReference> matchReferences = matchList.getMatches();

            List<AccountMatchData> accountMatchDataList = matchReferences.stream().map(matchReference -> {
                Match match = getMatchData(matchReference.getGameId());

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

                AccountMatchData accountMatchData = null;
                if (participant != null) {
                    int teamId = participant.getTeamId();
                    double teamKills = participants.stream()
                            .filter(p -> p.getTeamId() == teamId)
                            .mapToInt(p -> p.getStats().getKills()).sum();
                    ParticipantStats participantStats = participant.getStats();
                    double killParticipation = teamKills > 0 ?
                            ((participantStats.getKills() + participantStats.getAssists()) / teamKills) : 0;

                    accountMatchData = new AccountMatchData(
                            encryptedAccountId,
                            match.getGameId(),
                            participant.getSpell1Id(),
                            participant.getSpell2Id(),
                            killParticipation,
                            participantStats,
                            getRole(matchReference.getRole(), matchReference.getLane()),
                            matchReference.getChampion(),
                            matchReference.getQueue(),
                            matchReference.getTimestamp(),
                            match.getGameDuration(),
                            match.getGameVersion()
                    );

                    accountMatchDataRepository.save(accountMatchData);
                }

                return accountMatchData;
            }).collect(Collectors.toList());
            return accountMatchDataList;
        }

        return new ArrayList<>();
    }

    private Match getMatchData(long matchId) {
        logger.debug("getMatchData: " + matchId);
        return client.get()
                .uri("/lol/match/v4/matches/" + matchId)
                .retrieve()
                .bodyToMono(Match.class)
                .block();
    }

    private int getRole(String role, String lane) {
        int roleNum;
        switch (role) {
            case "SOLO":
                roleNum = lane.equals("TOP") ? 0 : 2;
                break;
            case "DUO_CARRY":
                roleNum = 3;
                break;
            case "DUO_SUPPORT":
                roleNum = 4;
                break;
            default:
                roleNum = 1;
                break;
        }

        return roleNum;
    }
}
