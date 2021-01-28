package com.gordonplumb.lolprofile.model;

public interface MatchShortDetails {
    int getChampion();
    int getSpell1Id();
    int getSpell2Id();
    int getPerk0();
    int getItem0();
    int getItem1();
    int getItem2();
    int getItem3();
    int getItem4();
    int getItem5();
    int getItem6();
    int getKills();
    int getDeaths();
    int getAssists();
    int getGold();
    int getTotalMinionsKilled();
    boolean getWin();
    String getRole();
    long getTimestamp();
    long getGameDuration();
    int getQueue();
    String getGameVersion();
}
