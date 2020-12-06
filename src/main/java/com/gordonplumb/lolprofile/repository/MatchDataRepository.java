package com.gordonplumb.lolprofile.repository;

import com.gordonplumb.lolprofile.model.AccountMatchReferenceId;
import com.gordonplumb.lolprofile.model.MatchData;
import org.springframework.data.repository.CrudRepository;

public interface MatchDataRepository extends CrudRepository<MatchData, AccountMatchReferenceId> {
}
