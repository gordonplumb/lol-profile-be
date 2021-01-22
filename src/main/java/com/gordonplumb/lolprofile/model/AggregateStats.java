package com.gordonplumb.lolprofile.model;

public interface AggregateStats {
    int getGamesPlayed();
    Double getWinRate();

    Integer getKills();
    Integer getDeaths();
    Integer getAssists();

    // do dpm instead
//    int getDamageDealtToChampions();
//    int getPhysicalDamageDealtToChampions();
//    int getMagicDamageDealtToChampions();
//    int getTrueDamageDealtToChampions();

//    int getDamageToTurrets();
//
//    int getSelfMitigatedDamage();
//
//    int getGoldEarned();
//    int getNeutralMinionsKilledEnemyJungle();
//    int getNeutralMinionsKilledTeamJungle();
//    int getMinionsKilled();
//
//    int getSightWardsBought();
//    int getVisionWardsBought();
//    int getWardsKilled();
//    int getWardsPlaced();
//    int getVisionScore();
//    int getTimeCCingOthers();
//    int getTotalHeal();

}
