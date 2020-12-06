package com.gordonplumb.lolprofile.repository;

import com.gordonplumb.lolprofile.model.AccountMatchReference;
import com.gordonplumb.lolprofile.model.AccountMatchReferenceId;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface AccountMatchReferenceRepository extends PagingAndSortingRepository<AccountMatchReference, AccountMatchReferenceId> {
    List<AccountMatchReference> findAllByAccountId(String accountId, Pageable pageable);
}
