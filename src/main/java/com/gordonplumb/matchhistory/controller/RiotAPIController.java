package com.gordonplumb.matchhistory.controller;

import com.gordonplumb.matchhistory.model.Account;
import com.gordonplumb.matchhistory.service.RiotAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path = "/riot")
public class RiotAPIController {
    @Autowired
    private RiotAPIService riotAPIService;

    @GetMapping(path = "/account")
    @ResponseBody
    public Account getAccount(@RequestParam String name) {
        Account account = riotAPIService.getAccount(name);
        return account;
    }

    @GetMapping(path = "/matches")
    public ResponseBody getNewMatches(@RequestParam String accountId) {
        return null;
    }
}
