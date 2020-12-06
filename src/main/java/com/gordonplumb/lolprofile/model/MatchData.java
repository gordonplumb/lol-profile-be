package com.gordonplumb.lolprofile.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(AccountMatchReferenceId.class)
public class MatchData {
    @Id
    private String accountId;
    @Id
    private long matchId;

    @Embedded
    private ParticipantStats participantStats;

    public MatchData() {}

    public MatchData(String accountId, long matchId, ParticipantStats participantStats) {
        this.accountId = accountId;
        this.matchId = matchId;
        this.participantStats = participantStats;
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

    public ParticipantStats getParticipantStats() {
        return participantStats;
    }

    public void setParticipantStats(ParticipantStats participantStats) {
        this.participantStats = participantStats;
    }
}
