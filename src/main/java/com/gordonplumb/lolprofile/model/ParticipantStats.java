package com.gordonplumb.lolprofile.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Embeddable;

@JsonIgnoreProperties(ignoreUnknown = true)
@Embeddable
public class ParticipantStats {
    private boolean win;

    private int item0;
    private int item1;
    private int item2;
    private int item3;
    private int item4;
    private int item5;
    private int item6;

    private int kills;
    private int deaths;
    private int assists;

    private int largestKillingSpree;
    private int largestMultiKill;
    private int doubleKills;
    private int tripleKills;
    private int quadraKills;
    private int pentaKills;
    private boolean firstBloodKill;
    private boolean firstBloodAssist;

    private int largestCriticalStrike;
    private int totalDamageDealt;
    private int magicDamageDealt;
    private int physicalDamageDealt;
    private int trueDamageDealt;
    private int totalDamageDealtToChampions;
    private int magicDamageDealtToChampions;
    private int physicalDamageDealtToChampions;
    private int trueDamageDealtToChampions;

    private int damageDealtToObjectives;
    private int damageDealtToTurrets;
    private boolean firstTowerKill;
    private boolean firstTowerAssist;

    private int totalHeal;
    private int damageSelfMitigated;
    private int totalDamageTaken;
    private int physicalDamageTaken;
    private int magicalDamageTaken;
    private int trueDamageTaken;

    private int visionScore;
    private int visionWardsBoughtInGame;
    private int sightWardsBoughtInGame;
    private int wardsPlaced;
    private int wardsKilled;
    private int timeCCingOthers;
    private int totalTimeCrowdControlDealt;

    private int goldEarned;
    private int goldSpent;
    private int totalMinionsKilled;
    private int neutralMinionsKilled;
    private int neutralMinionsKilledTeamJungle;
    private int neutralMinionsKilledEnemyJungle;

    private int perk0;
    private int perk0Var1;
    private int perk0Var2;
    private int perk0Var3;
    private int perk1;
    private int perk1Var1;
    private int perk1Var2;
    private int perk1Var3;
    private int perk2;
    private int perk2Var1;
    private int perk2Var2;
    private int perk2Var3;
    private int perk3;
    private int perk3Var1;
    private int perk3Var2;
    private int perk3Var3;
    private int perk4;
    private int perk4Var1;
    private int perk4Var2;
    private int perk4Var3;
    private int perk5;
    private int perk5Var1;
    private int perk5Var2;
    private int perk5Var3;
    private int perkPrimaryStyle;
    private int perkSubStyle;
    private int statPerk0;
    private int statPerk1;
    private int statPerk2;

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    public int getItem0() {
        return item0;
    }

    public void setItem0(int item0) {
        this.item0 = item0;
    }

    public int getItem1() {
        return item1;
    }

    public void setItem1(int item1) {
        this.item1 = item1;
    }

    public int getItem2() {
        return item2;
    }

    public void setItem2(int item2) {
        this.item2 = item2;
    }

    public int getItem3() {
        return item3;
    }

    public void setItem3(int item3) {
        this.item3 = item3;
    }

    public int getItem4() {
        return item4;
    }

    public void setItem4(int item4) {
        this.item4 = item4;
    }

    public int getItem5() {
        return item5;
    }

    public void setItem5(int item5) {
        this.item5 = item5;
    }

    public int getItem6() {
        return item6;
    }

    public void setItem6(int item6) {
        this.item6 = item6;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getLargestKillingSpree() {
        return largestKillingSpree;
    }

    public void setLargestKillingSpree(int largestKillingSpree) {
        this.largestKillingSpree = largestKillingSpree;
    }

    public int getLargestMultiKill() {
        return largestMultiKill;
    }

    public void setLargestMultiKill(int largestMultiKill) {
        this.largestMultiKill = largestMultiKill;
    }

    public int getDoubleKills() {
        return doubleKills;
    }

    public void setDoubleKills(int doubleKills) {
        this.doubleKills = doubleKills;
    }

    public int getTripleKills() {
        return tripleKills;
    }

    public void setTripleKills(int tripleKills) {
        this.tripleKills = tripleKills;
    }

    public int getQuadraKills() {
        return quadraKills;
    }

    public void setQuadraKills(int quadraKills) {
        this.quadraKills = quadraKills;
    }

    public int getPentaKills() {
        return pentaKills;
    }

    public void setPentaKills(int pentaKills) {
        this.pentaKills = pentaKills;
    }

    public boolean isFirstBloodKill() {
        return firstBloodKill;
    }

    public void setFirstBloodKill(boolean firstBloodKill) {
        this.firstBloodKill = firstBloodKill;
    }

    public boolean isFirstBloodAssist() {
        return firstBloodAssist;
    }

    public void setFirstBloodAssist(boolean firstBloodAssist) {
        this.firstBloodAssist = firstBloodAssist;
    }

    public int getLargestCriticalStrike() {
        return largestCriticalStrike;
    }

    public void setLargestCriticalStrike(int largestCriticalStrike) {
        this.largestCriticalStrike = largestCriticalStrike;
    }

    public int getTotalDamageDealt() {
        return totalDamageDealt;
    }

    public void setTotalDamageDealt(int totalDamageDealt) {
        this.totalDamageDealt = totalDamageDealt;
    }

    public int getMagicDamageDealt() {
        return magicDamageDealt;
    }

    public void setMagicDamageDealt(int magicDamageDealt) {
        this.magicDamageDealt = magicDamageDealt;
    }

    public int getPhysicalDamageDealt() {
        return physicalDamageDealt;
    }

    public void setPhysicalDamageDealt(int physicalDamageDealt) {
        this.physicalDamageDealt = physicalDamageDealt;
    }

    public int getTrueDamageDealt() {
        return trueDamageDealt;
    }

    public void setTrueDamageDealt(int trueDamageDealt) {
        this.trueDamageDealt = trueDamageDealt;
    }

    public int getTotalDamageDealtToChampions() {
        return totalDamageDealtToChampions;
    }

    public void setTotalDamageDealtToChampions(int totalDamageDealtToChampions) {
        this.totalDamageDealtToChampions = totalDamageDealtToChampions;
    }

    public int getMagicDamageDealtToChampions() {
        return magicDamageDealtToChampions;
    }

    public void setMagicDamageDealtToChampions(int magicDamageDealtToChampions) {
        this.magicDamageDealtToChampions = magicDamageDealtToChampions;
    }

    public int getPhysicalDamageDealtToChampions() {
        return physicalDamageDealtToChampions;
    }

    public void setPhysicalDamageDealtToChampions(int physicalDamageDealtToChampions) {
        this.physicalDamageDealtToChampions = physicalDamageDealtToChampions;
    }

    public int getTrueDamageDealtToChampions() {
        return trueDamageDealtToChampions;
    }

    public void setTrueDamageDealtToChampions(int trueDamageDealtToChampions) {
        this.trueDamageDealtToChampions = trueDamageDealtToChampions;
    }

    public int getDamageDealtToObjectives() {
        return damageDealtToObjectives;
    }

    public void setDamageDealtToObjectives(int damageDealtToObjectives) {
        this.damageDealtToObjectives = damageDealtToObjectives;
    }

    public int getDamageDealtToTurrets() {
        return damageDealtToTurrets;
    }

    public void setDamageDealtToTurrets(int damageDealtToTurrets) {
        this.damageDealtToTurrets = damageDealtToTurrets;
    }

    public boolean isFirstTowerKill() {
        return firstTowerKill;
    }

    public void setFirstTowerKill(boolean firstTowerKill) {
        this.firstTowerKill = firstTowerKill;
    }

    public boolean isFirstTowerAssist() {
        return firstTowerAssist;
    }

    public void setFirstTowerAssist(boolean firstTowerAssist) {
        this.firstTowerAssist = firstTowerAssist;
    }

    public int getTotalHeal() {
        return totalHeal;
    }

    public void setTotalHeal(int totalHeal) {
        this.totalHeal = totalHeal;
    }

    public int getDamageSelfMitigated() {
        return damageSelfMitigated;
    }

    public void setDamageSelfMitigated(int damageSelfMitigated) {
        this.damageSelfMitigated = damageSelfMitigated;
    }

    public int getTotalDamageTaken() {
        return totalDamageTaken;
    }

    public void setTotalDamageTaken(int totalDamageTaken) {
        this.totalDamageTaken = totalDamageTaken;
    }

    public int getPhysicalDamageTaken() {
        return physicalDamageTaken;
    }

    public void setPhysicalDamageTaken(int physicalDamageTaken) {
        this.physicalDamageTaken = physicalDamageTaken;
    }

    public int getMagicalDamageTaken() {
        return magicalDamageTaken;
    }

    public void setMagicalDamageTaken(int magicalDamageTaken) {
        this.magicalDamageTaken = magicalDamageTaken;
    }

    public int getTrueDamageTaken() {
        return trueDamageTaken;
    }

    public void setTrueDamageTaken(int trueDamageTaken) {
        this.trueDamageTaken = trueDamageTaken;
    }

    public int getVisionScore() {
        return visionScore;
    }

    public void setVisionScore(int visionScore) {
        this.visionScore = visionScore;
    }

    public int getVisionWardsBoughtInGame() {
        return visionWardsBoughtInGame;
    }

    public void setVisionWardsBoughtInGame(int visionWardsBoughtInGame) {
        this.visionWardsBoughtInGame = visionWardsBoughtInGame;
    }

    public int getSightWardsBoughtInGame() {
        return sightWardsBoughtInGame;
    }

    public void setSightWardsBoughtInGame(int sightWardsBoughtInGame) {
        this.sightWardsBoughtInGame = sightWardsBoughtInGame;
    }

    public int getWardsPlaced() {
        return wardsPlaced;
    }

    public void setWardsPlaced(int wardsPlaced) {
        this.wardsPlaced = wardsPlaced;
    }

    public int getWardsKilled() {
        return wardsKilled;
    }

    public void setWardsKilled(int wardsKilled) {
        this.wardsKilled = wardsKilled;
    }

    public int getTimeCCingOthers() {
        return timeCCingOthers;
    }

    public void setTimeCCingOthers(int timeCCingOthers) {
        this.timeCCingOthers = timeCCingOthers;
    }

    public int getTotalTimeCrowdControlDealt() {
        return totalTimeCrowdControlDealt;
    }

    public void setTotalTimeCrowdControlDealt(int totalTimeCrowdControlDealt) {
        this.totalTimeCrowdControlDealt = totalTimeCrowdControlDealt;
    }

    public int getGoldEarned() {
        return goldEarned;
    }

    public void setGoldEarned(int goldEarned) {
        this.goldEarned = goldEarned;
    }

    public int getGoldSpent() {
        return goldSpent;
    }

    public void setGoldSpent(int goldSpent) {
        this.goldSpent = goldSpent;
    }

    public int getTotalMinionsKilled() {
        return totalMinionsKilled;
    }

    public void setTotalMinionsKilled(int totalMinionsKilled) {
        this.totalMinionsKilled = totalMinionsKilled;
    }

    public int getNeutralMinionsKilled() {
        return neutralMinionsKilled;
    }

    public void setNeutralMinionsKilled(int neutralMinionsKilled) {
        this.neutralMinionsKilled = neutralMinionsKilled;
    }

    public int getNeutralMinionsKilledTeamJungle() {
        return neutralMinionsKilledTeamJungle;
    }

    public void setNeutralMinionsKilledTeamJungle(int neutralMinionsKilledTeamJungle) {
        this.neutralMinionsKilledTeamJungle = neutralMinionsKilledTeamJungle;
    }

    public int getNeutralMinionsKilledEnemyJungle() {
        return neutralMinionsKilledEnemyJungle;
    }

    public void setNeutralMinionsKilledEnemyJungle(int neutralMinionsKilledEnemyJungle) {
        this.neutralMinionsKilledEnemyJungle = neutralMinionsKilledEnemyJungle;
    }

    public int getPerk0() {
        return perk0;
    }

    public void setPerk0(int perk0) {
        this.perk0 = perk0;
    }

    public int getPerk0Var1() {
        return perk0Var1;
    }

    public void setPerk0Var1(int perk0Var1) {
        this.perk0Var1 = perk0Var1;
    }

    public int getPerk0Var2() {
        return perk0Var2;
    }

    public void setPerk0Var2(int perk0Var2) {
        this.perk0Var2 = perk0Var2;
    }

    public int getPerk0Var3() {
        return perk0Var3;
    }

    public void setPerk0Var3(int perk0Var3) {
        this.perk0Var3 = perk0Var3;
    }

    public int getPerk1() {
        return perk1;
    }

    public void setPerk1(int perk1) {
        this.perk1 = perk1;
    }

    public int getPerk1Var1() {
        return perk1Var1;
    }

    public void setPerk1Var1(int perk1Var1) {
        this.perk1Var1 = perk1Var1;
    }

    public int getPerk1Var2() {
        return perk1Var2;
    }

    public void setPerk1Var2(int perk1Var2) {
        this.perk1Var2 = perk1Var2;
    }

    public int getPerk1Var3() {
        return perk1Var3;
    }

    public void setPerk1Var3(int perk1Var3) {
        this.perk1Var3 = perk1Var3;
    }

    public int getPerk2() {
        return perk2;
    }

    public void setPerk2(int perk2) {
        this.perk2 = perk2;
    }

    public int getPerk2Var1() {
        return perk2Var1;
    }

    public void setPerk2Var1(int perk2Var1) {
        this.perk2Var1 = perk2Var1;
    }

    public int getPerk2Var2() {
        return perk2Var2;
    }

    public void setPerk2Var2(int perk2Var2) {
        this.perk2Var2 = perk2Var2;
    }

    public int getPerk2Var3() {
        return perk2Var3;
    }

    public void setPerk2Var3(int perk2Var3) {
        this.perk2Var3 = perk2Var3;
    }

    public int getPerk3() {
        return perk3;
    }

    public void setPerk3(int perk3) {
        this.perk3 = perk3;
    }

    public int getPerk3Var1() {
        return perk3Var1;
    }

    public void setPerk3Var1(int perk3Var1) {
        this.perk3Var1 = perk3Var1;
    }

    public int getPerk3Var2() {
        return perk3Var2;
    }

    public void setPerk3Var2(int perk3Var2) {
        this.perk3Var2 = perk3Var2;
    }

    public int getPerk3Var3() {
        return perk3Var3;
    }

    public void setPerk3Var3(int perk3Var3) {
        this.perk3Var3 = perk3Var3;
    }

    public int getPerk4() {
        return perk4;
    }

    public void setPerk4(int perk4) {
        this.perk4 = perk4;
    }

    public int getPerk4Var1() {
        return perk4Var1;
    }

    public void setPerk4Var1(int perk4Var1) {
        this.perk4Var1 = perk4Var1;
    }

    public int getPerk4Var2() {
        return perk4Var2;
    }

    public void setPerk4Var2(int perk4Var2) {
        this.perk4Var2 = perk4Var2;
    }

    public int getPerk4Var3() {
        return perk4Var3;
    }

    public void setPerk4Var3(int perk4Var3) {
        this.perk4Var3 = perk4Var3;
    }

    public int getPerk5() {
        return perk5;
    }

    public void setPerk5(int perk5) {
        this.perk5 = perk5;
    }

    public int getPerk5Var1() {
        return perk5Var1;
    }

    public void setPerk5Var1(int perk5Var1) {
        this.perk5Var1 = perk5Var1;
    }

    public int getPerk5Var2() {
        return perk5Var2;
    }

    public void setPerk5Var2(int perk5Var2) {
        this.perk5Var2 = perk5Var2;
    }

    public int getPerk5Var3() {
        return perk5Var3;
    }

    public void setPerk5Var3(int perk5Var3) {
        this.perk5Var3 = perk5Var3;
    }

    public int getPerkPrimaryStyle() {
        return perkPrimaryStyle;
    }

    public void setPerkPrimaryStyle(int perkPrimaryStyle) {
        this.perkPrimaryStyle = perkPrimaryStyle;
    }

    public int getPerkSubStyle() {
        return perkSubStyle;
    }

    public void setPerkSubStyle(int perkSubStyle) {
        this.perkSubStyle = perkSubStyle;
    }

    public int getStatPerk0() {
        return statPerk0;
    }

    public void setStatPerk0(int statPerk0) {
        this.statPerk0 = statPerk0;
    }

    public int getStatPerk1() {
        return statPerk1;
    }

    public void setStatPerk1(int statPerk1) {
        this.statPerk1 = statPerk1;
    }

    public int getStatPerk2() {
        return statPerk2;
    }

    public void setStatPerk2(int statPerk2) {
        this.statPerk2 = statPerk2;
    }
}
