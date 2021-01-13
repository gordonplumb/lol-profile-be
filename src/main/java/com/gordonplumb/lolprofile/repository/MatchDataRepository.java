package com.gordonplumb.lolprofile.repository;

import com.gordonplumb.lolprofile.model.AccountMatchDataId;
import com.gordonplumb.lolprofile.model.MatchData;
import org.springframework.data.repository.CrudRepository;

public interface MatchDataRepository extends CrudRepository<MatchData, AccountMatchDataId> {
}
