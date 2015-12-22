package eu.happycoders.adventofcode2015.day22;

import static eu.happycoders.adventofcode2015.day22.SpellType.DRAIN;
import static eu.happycoders.adventofcode2015.day22.SpellType.MAGIC_MISSILE;
import static eu.happycoders.adventofcode2015.day22.SpellType.POISON;
import static eu.happycoders.adventofcode2015.day22.SpellType.RECHARGE;
import static eu.happycoders.adventofcode2015.day22.SpellType.SHIELD;
import static eu.happycoders.adventofcode2015.day22.TestInputs.TEST_BOSS_STATS;
import static eu.happycoders.adventofcode2015.day22.TestInputs.TEST_BOSS_WITH_14_HIT_POINTS;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;
import org.junit.jupiter.api.Test;

class StrategyFinderTest {

  @Test
  void
      given10PlayerHitPointsAnd250ManaAndTestBossStats_findCheapestSequenceOfSpellsToWin_returnsPoisonAndMagicMissile() {
    GameState startingGameState = GameState.startGame(10, 250, TEST_BOSS_STATS, false);

    Optional<SequenceOfSpells> spells =
        StrategyFinder.findCheapestSequenceOfSpellsToWin(startingGameState);

    assertThat(spells).isNotEmpty();
    assertThat(spells.get().getSpellTypes()).containsExactly(POISON, MAGIC_MISSILE);
  }

  @Test
  void
      given10PlayerHitPointsAnd250ManaAndBossWith14HitPoints_findCheapestSequenceOfSpellsToWin_returnsPoisonAndMagicMissile() {
    GameState startingGameState = GameState.startGame(10, 250, TEST_BOSS_WITH_14_HIT_POINTS, false);

    Optional<SequenceOfSpells> spells =
        StrategyFinder.findCheapestSequenceOfSpellsToWin(startingGameState);

    assertThat(spells).isNotEmpty();
    assertThat(spells.get().getSpellTypes())
        .containsExactly(RECHARGE, SHIELD, DRAIN, POISON, MAGIC_MISSILE);
  }
}
