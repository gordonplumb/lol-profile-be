package com.gordonplumb.lolprofile.model;

public interface AggregateStats {
    int getGamesPlayed();
    Integer getWins();

    Integer getKills();
    Integer getDeaths();
    Integer getAssists();
    Double getKillParticipation();

    Integer getDoubleKills();
    Integer getTripleKills();
    Integer getQuadraKills();
    Integer getPentaKills();

    Integer getFirstBlood();
    Integer getFirstTower();

    Double getDamagePerMinute();
    Double getHealPerMinute();

    Double getGoldPerMinute();
    Double getCsPerMinute();

    Double getWardsPlacedPerHour();
    Double getWardsKilledPerHour();
    Double getVisionScorePerHour();

//    int getTimeCCingOthers();

}
