package com.gordonplumb.lolprofile.controller;

import com.gordonplumb.lolprofile.model.*;
import com.gordonplumb.lolprofile.service.ProfileService;
import com.gordonplumb.lolprofile.service.RiotAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/api")
public class ProfileController {
    @Autowired
    private RiotAPIService riotAPIService;

    @Autowired
    private ProfileService profileService;

    @GetMapping(path = "/account")
    @ResponseBody
    public Account getAccount(@RequestParam String name) {
        Account account = profileService.getAccount(name);

        if (account == null) {
            try {
                account = riotAPIService.getAccount(name);
                profileService.createAccount(account);
            } catch (WebClientResponseException ex) {
                handleException(ex, "Get Account");
            }
        }

        return account;
    }

    @GetMapping(path = "/matches")
    @ResponseBody
    public Page<MatchShortDetails> getMatches(@RequestParam String accountId, @RequestParam int page, @RequestParam int size) {
        Page<MatchShortDetails> resultPage = profileService.findPaginated(accountId, page, size);

        return resultPage;
    }

    @GetMapping(path = "/updateAccount")
    @ResponseBody
    public void updateAccount(@RequestParam String name) {
        try {
            Account account = riotAPIService.getAccount(name);

            try {
                Account oldAccount = profileService.getAccount(name);

                if (oldAccount == null) {
                    Date newLastUpdatedDate = riotAPIService.updateMatches(account.getAccountId(), null);
                    account.setLastUpdatedDate(newLastUpdatedDate);
                    profileService.createAccount(account);
                } else {
                    Date newLastUpdatedDate = riotAPIService.updateMatches(
                            account.getAccountId(),
                            oldAccount.getLastUpdatedDate()
                    );
                    account.setLastUpdatedDate(newLastUpdatedDate);
                    profileService.updateAccount(account);
                }
            } catch (WebClientResponseException ex) {
                handleException(ex, "Get Matches");
            }
        } catch (WebClientResponseException ex) {
            handleException(ex, "Get Account");
        }

    }

    @GetMapping(path = "/stats")
    @ResponseBody
    public AggregateStats getStats(
            @RequestParam String accountId,
            @RequestParam(required = false) Integer champion,
            @RequestParam(required = false) List<Integer> queues,
            @RequestParam(required = false) List<Integer> roles) {
        return profileService.getStats(accountId, champion, queues, roles);
    }

    private void handleException(WebClientResponseException ex, String service) {
        int statusCode = ex.getRawStatusCode();
        if (statusCode == 404) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, service);
        }
        if (statusCode == 429 || statusCode > 500) {
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE,
                    service + " service unavailable");
        }
        throw new ResponseStatusException(HttpStatus.valueOf(statusCode), ex.getMessage());
    }
}
