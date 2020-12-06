package com.gordonplumb.lolprofile.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(AccountMatchReferenceId.class)
public class AccountMatchReference {
    @Id
    private String accountId;
    @Id
    private long matchId;
    private String role;
    private int champion;
    private int queue;
    private String lane;
    private long timestamp;

    public AccountMatchReference() {}

    public AccountMatchReference(String accountId, long matchId, String role, int champion, int queue, String lane, long timestamp) {
        this.accountId = accountId;
        this.matchId = matchId;
        this.role = role;
        this.champion = champion;
        this.queue = queue;
        this.lane = lane;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
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

    public String getLane() {
        return lane;
    }

    public void setLane(String lane) {
        this.lane = lane;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
