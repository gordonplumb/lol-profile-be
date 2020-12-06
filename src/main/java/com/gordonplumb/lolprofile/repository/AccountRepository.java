package com.gordonplumb.lolprofile.repository;

import com.gordonplumb.lolprofile.model.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountRepository extends CrudRepository<Account, String> {
    List<Account> findByName(String name);
}
