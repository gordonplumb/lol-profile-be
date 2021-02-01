package com.gordonplumb.lolprofile.model;

public interface AggregateStats {
    int getGamesPlayed();
    Integer getWins();
    Long getGameDuration();

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
    Double getDamageTakenPerMinute();
    Double getDamageMitigatedPerMinute();
    Integer getCrowdControlPerMinute();

    Double getGoldPerMinute();
    Double getCsPerMinute();

    Double getWardsPlacedPerHour();
    Double getWardsKilledPerHour();
    Double getVisionScorePerHour();

//    int getTimeCCingOthers();

}
