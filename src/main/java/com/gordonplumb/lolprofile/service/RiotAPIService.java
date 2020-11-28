package com.gordonplumb.lolprofile.service;

import com.gordonplumb.lolprofile.model.Account;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.logging.Logger;

@ConfigurationProperties(prefix = "riot")
@Service
public class RiotAPIService {
    private String apiKey = System.getenv("RIOT_API_KEY");
    private Logger logger = Logger.getLogger(RiotAPIService.class.toString());

    private WebClient client = WebClient.builder().baseUrl("https://na1.api.riotgames.com").defaultHeader("X-Riot-Token", apiKey).build();

    public Account getAccount(String name) {
        logger.info("getAccount: " + name);
        return client.get()
                .uri("/lol/summoner/v4/summoners/by-name/" + name)
                .retrieve()
                .bodyToMono(Account.class)
                .block();
    }

}
