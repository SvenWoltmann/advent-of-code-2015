package eu.happycoders.adventofcode2015.day21;

import static eu.happycoders.adventofcode2015.day21.Shop.CHAINMAIL;
import static eu.happycoders.adventofcode2015.day21.Shop.DAGGER;
import static eu.happycoders.adventofcode2015.day21.Shop.DAMAGE_3;
import static eu.happycoders.adventofcode2015.day21.Shop.DEFENSE_1;
import static eu.happycoders.adventofcode2015.day21.Shop.WARHAMMER;
import static eu.happycoders.adventofcode2015.day21.TestInputs.TEST_BOSS_STATS;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;
import org.junit.jupiter.api.Test;

class StrategyFinderTest {

  @Test
  void
      given12PlayerHitPointsAndTestBossStats_findCheapestItemSetToWin_returnsWarhammerChainmillNoRings() {
    Optional<ItemSet> cheapestItemSetToWin =
        StrategyFinder.findCheapestItemSetToWin(12, TEST_BOSS_STATS);

    assertThat(cheapestItemSetToWin)
        .isNotEmpty()
        .hasValue(new ItemSet(WARHAMMER, CHAINMAIL, Collections.emptyList()));
  }

  @Test
  void
      given12PlayerHitPointsAndTestBossStats_findMostExpensiveItemSetToLose_returnsDaggerNoArmorDamage3Defense1() {
    Optional<ItemSet> mostExpensiveItemSetToLose =
        StrategyFinder.findMostExpensiveItemSetToLose(12, TEST_BOSS_STATS);

    assertThat(mostExpensiveItemSetToLose)
        .isNotEmpty()
        .hasValue(new ItemSet(DAGGER, null, Arrays.asList(DAMAGE_3, DEFENSE_1)));
  }
}
