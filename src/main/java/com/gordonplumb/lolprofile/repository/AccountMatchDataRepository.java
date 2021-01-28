package com.gordonplumb.lolprofile.repository;

import com.gordonplumb.lolprofile.model.AccountMatchData;
import com.gordonplumb.lolprofile.model.AccountMatchDataId;
import com.gordonplumb.lolprofile.model.AggregateStats;
import com.gordonplumb.lolprofile.model.MatchShortDetails;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface AccountMatchDataRepository extends PagingAndSortingRepository<AccountMatchData, AccountMatchDataId> {
    @Query(
        value = "SELECT a.champion, a.spell1id, a.spell2id, a.perk0, a.item0, a.item1, a.item2, a.item3, a.item4," +
                "       a.item5, a.item6, a.kills, a.deaths, a.assists, a.gold_earned as gold," +
                "       (a.total_minions_killed + a.neutral_minions_killed) as totalMinionsKilled, a.win, a.role," +
                "       a.timestamp, a.game_duration as gameDuration, a.queue, a.game_version as gameVersion" +
                "  FROM account_match_data a" +
                " WHERE a.account_id = ?1",
        nativeQuery = true
    )
    List<MatchShortDetails> findAllByAccountId(String accountId, Pageable pageable);

    @Query(
        value = "SELECT COUNT(*) as gamesPlayed, SUM(a.win) as wins, AVG(a.kills) as kills," +
                "       AVG(a.deaths) as deaths, AVG(a.assists) as assists," +
                "       AVG(a.kill_participation) as killParticipation, SUM(a.double_kills) as doubleKills," +
                "       SUM(a.triple_kills) as tripleKills, SUM(a.quadra_kills) as quadraKills," +
                "       SUM(a.penta_kills) as pentaKills," +
                "       SUM(CASE WHEN a.first_blood_kill OR a.first_blood_assist THEN 1 ELSE 0 END) as firstBlood," +
                "       SUM(CASE WHEN a.first_tower_kill OR a.first_tower_assist THEN 1 ELSE 0 END) as firstTower," +
                "       AVG(a.total_damage_dealt_to_champions / a.game_duration * 60) as damagePerMinute," +
                "       AVG(a.total_heal / a.game_duration * 60) as healPerMinute," +
                "       AVG((a.total_minions_killed + a.neutral_minions_killed) / a.game_duration * 60) as csPerMinute," +
                "       AVG(a.gold_earned / a.game_duration * 60) as goldPerMinute," +
                "       AVG(a.wards_placed / a.game_duration * 3600) as wardsPlacedPerHour," +
                "       AVG(a.wards_killed / a.game_duration * 3600) as wardsKilledPerHour," +
                "       AVG(a.vision_score / a.game_duration * 3600) as visionScorePerHour" +
                "  FROM account_match_data a" +
                " WHERE a.account_id = ?1" +
                "   AND a.queue in (?2)" +
                "   AND a.role in (?3)",
        nativeQuery = true
    )
    AggregateStats getStats(String accountId, List<Integer> queues, List<Integer> roles);

    @Query(
            value = "SELECT COUNT(*) as gamesPlayed, AVG(a.win) as winRate, AVG(a.kills) as kills, AVG(a.deaths) as deaths," +
                    "       AVG(a.assists) as assists" +
                    "  FROM account_match_data a" +
                    " WHERE a.account_id = ?1" +
                    "   AND a.champion = ?2" +
                    "   AND a.queue in (?3)" +
                    "   AND a.role in (?4)",
            nativeQuery = true
    )
    AggregateStats getStatsByChampion(String accountId, int champion, List<Integer> queues, List<Integer> roles);
}
