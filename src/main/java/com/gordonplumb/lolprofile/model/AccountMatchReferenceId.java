package com.gordonplumb.lolprofile.model;

import java.io.Serializable;
import java.util.Objects;

public class AccountMatchReferenceId implements Serializable {
    private String accountId;
    private long matchId;

    public AccountMatchReferenceId() {}

    public AccountMatchReferenceId(String accountId, long matchId) {
        this.accountId = accountId;
        this.matchId = matchId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public long getMatchId() {
        return matchId;
    }

    public void setMatchId(long matchId) {
        this.matchId = matchId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountMatchReferenceId that = (AccountMatchReferenceId) o;
        return matchId == that.matchId &&
                accountId.equals(that.accountId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, matchId);
    }
}
