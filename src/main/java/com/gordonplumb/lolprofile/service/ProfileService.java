package com.gordonplumb.lolprofile.service;

import com.gordonplumb.lolprofile.model.Account;
import com.gordonplumb.lolprofile.model.AccountMatchReference;
import com.gordonplumb.lolprofile.model.AccountMatchReferenceId;
import com.gordonplumb.lolprofile.model.MatchData;
import com.gordonplumb.lolprofile.repository.AccountMatchReferenceRepository;
import com.gordonplumb.lolprofile.repository.AccountRepository;
import com.gordonplumb.lolprofile.repository.MatchDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountMatchReferenceRepository accountMatchReferenceRepository;

    @Autowired
    private MatchDataRepository matchDataRepository;

    private Logger logger = LoggerFactory.getLogger(ProfileService.class);

    public Account getAccount(String name) {
        logger.debug("getAccount: " + name);
        List<Account> result = accountRepository.findByName(name);
        if (result.size() > 0) {
            return result.get(0);
        } else {
            return null;
        }
    }

    public void createAccount(Account account) {
        logger.debug("createAccount: " + account.getName());
        accountRepository.save(account);
    }

    public void updateAccount(Account account) {
        logger.debug("updateAccount: " + account.getName());
        accountRepository.findById(account.getAccountId()).ifPresent(result -> {
            accountRepository.save(account);
        });
    }

    public List<AccountMatchReference> findPaginated(String accountId, int page, int size) {
        logger.debug("findPaginated: " + accountId + ", " + page + ", " + size);
        Pageable pageable = PageRequest.of(page, size, Sort.by("timestamp").descending());
        return accountMatchReferenceRepository.findAllByAccountId(accountId, pageable);
    }

    public MatchData getMatchData(String accountId, long matchId) {
        logger.debug("getMatchData: " + accountId + ", " + matchId);
        return matchDataRepository.findById(new AccountMatchReferenceId(accountId, matchId)).orElse(null);
    }
}