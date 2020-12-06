package com.gordonplumb.lolprofile.controller;

import com.gordonplumb.lolprofile.model.Account;
import com.gordonplumb.lolprofile.model.AccountMatchReference;
import com.gordonplumb.lolprofile.model.MatchData;
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
    public List<AccountMatchReference> getMatches(@RequestParam String accountId, @RequestParam int page, @RequestParam int size) {
        List<AccountMatchReference> resultPage = profileService.findPaginated(accountId, page, size);

        return resultPage;
    }

    @GetMapping(path = "/matchData")
    @ResponseBody
    public MatchData getMatchData(@RequestParam String accountId, @RequestParam long matchId) {
        return profileService.getMatchData(accountId, matchId);
    }

    @GetMapping(path = "/updateAccount")
    @ResponseBody
    public Account updateAccount(@RequestParam String name) {
        Account account = riotAPIService.getAccount(name);
        profileService.updateAccount(account);
        return account;
    }

    @GetMapping(path = "/updateMatches")
    @ResponseBody
    public List<AccountMatchReference> getNewMatches(@RequestParam String accountId) {
        List<AccountMatchReference> matchlist = riotAPIService.getMatches(accountId);
        return matchlist;
    }

}