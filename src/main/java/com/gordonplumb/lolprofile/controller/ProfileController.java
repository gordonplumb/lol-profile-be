package com.gordonplumb.lolprofile.controller;

import com.gordonplumb.lolprofile.model.*;
import com.gordonplumb.lolprofile.service.ProfileService;
import com.gordonplumb.lolprofile.service.RiotAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
            account = riotAPIService.getAccount(name);
            profileService.createAccount(account);
        }
        return account;
    }

    @GetMapping(path = "/matches")
    @ResponseBody
    public List<MatchShortDetails> getMatches(@RequestParam String accountId, @RequestParam int page, @RequestParam int size) {
        List<MatchShortDetails> resultPage = profileService.findPaginated(accountId, page, size);

        return resultPage;
    }

    @GetMapping(path = "/matchData")
    @ResponseBody
    public MatchData getMatchData(@RequestParam String accountId, @RequestParam long matchId) {
        return profileService.getMatchData(accountId, matchId);
    }

    @GetMapping(path = "/updateAccount")
    @ResponseBody
    public void updateAccount(@RequestParam String name) {
        Account account = riotAPIService.getAccount(name);
        profileService.updateAccount(account);
        riotAPIService.getMatches(account.getAccountId());
    }

    @GetMapping(path = "/updateMatches")
    @ResponseBody
    public List<AccountMatchData> getNewMatches(@RequestParam String accountId) {
        List<AccountMatchData> matchlist = riotAPIService.getMatches(accountId);
        return matchlist;
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

}
