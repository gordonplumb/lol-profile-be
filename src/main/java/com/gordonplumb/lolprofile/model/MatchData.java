package com.gordonplumb.lolprofile.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(AccountMatchDataId.class)
public class MatchData {
    @Id
    private String accountId;
    @Id
    private long matchId;

    private int spell1Id;
    private int spell2Id;

    @Embedded
    private ParticipantStats participantStats;

    public MatchData() {}

    public MatchData(String accountId, long matchId, int spell1Id, int spell2Id, ParticipantStats participantStats) {
        this.accountId = accountId;
        this.matchId = matchId;
        this.participantStats = participantStats;
        this.spell1Id = spell1Id;
        this.spell2Id = spell2Id;
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

    public int getSpell1Id() {
        return spell1Id;
    }

    public void setSpell1Id(int spell1Id) {
        this.spell1Id = spell1Id;
    }

    public int getSpell2Id() {
        return spell2Id;
    }

    public void setSpell2Id(int spell2Id) {
        this.spell2Id = spell2Id;
    }

    public ParticipantStats getParticipantStats() {
        return participantStats;
    }

    public void setParticipantStats(ParticipantStats participantStats) {
        this.participantStats = participantStats;
    }
}
