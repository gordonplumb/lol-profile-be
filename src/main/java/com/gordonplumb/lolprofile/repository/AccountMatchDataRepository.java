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
                "       (a.total_minions_killed + a.neutral_minions_killed_team_jungle + " +
                "       a.neutral_minions_killed_enemy_jungle) as totalMinionsKilled, a.win, a.role, a.timestamp," +
                "       a.queue" +
                "  FROM account_match_data a" +
                " WHERE a.account_id = ?1",
        nativeQuery = true
    )
    List<MatchShortDetails> findAllByAccountId(String accountId, Pageable pageable);

    @Query(
        value = "SELECT COUNT(*) as gamesPlayed, AVG(a.win) as winRate, AVG(a.kills) as kills, AVG(a.deaths) as deaths," +
                "       AVG(a.assists) as assists" +
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
