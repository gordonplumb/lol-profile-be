package com.gordonplumb.lolprofile.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(AccountMatchDataId.class)
public class AccountMatchData {
    @Id
    private String accountId;
    @Id
    private long matchId;

    private int spell1Id;
    private int spell2Id;

    @Embedded
    private ParticipantStats participantStats;
    private int role;
    private int champion;
    private int queue;
    private long timestamp;

    public AccountMatchData() {}

    public AccountMatchData(String accountId, long matchId, int spell1Id, int spell2Id, ParticipantStats participantStats, int role, int champion, int queue, long timestamp) {
        this.accountId = accountId;
        this.matchId = matchId;
        this.spell1Id = spell1Id;
        this.spell2Id = spell2Id;
        this.participantStats = participantStats;
        this.role = role;
        this.champion = champion;
        this.queue = queue;
        this.timestamp = timestamp;
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

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getChampion() {
        return champion;
    }

    public void setChampion(int champion) {
        this.champion = champion;
    }

    public int getQueue() {
        return queue;
    }

    public void setQueue(int queue) {
        this.queue = queue;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
