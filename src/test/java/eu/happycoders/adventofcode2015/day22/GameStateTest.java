package eu.happycoders.adventofcode2015.day22;

import static eu.happycoders.adventofcode2015.day22.SpellType.DRAIN;
import static eu.happycoders.adventofcode2015.day22.SpellType.MAGIC_MISSILE;
import static eu.happycoders.adventofcode2015.day22.SpellType.POISON;
import static eu.happycoders.adventofcode2015.day22.SpellType.RECHARGE;
import static eu.happycoders.adventofcode2015.day22.SpellType.SHIELD;
import static eu.happycoders.adventofcode2015.day22.TestInputs.TEST_BOSS_STATS;
import static eu.happycoders.adventofcode2015.day22.TestInputs.TEST_BOSS_WITH_14_HIT_POINTS;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class GameStateTest {

  @Test
  void givenAGameWithTestPlayerAndBossStats_playAccordingToExample1_getWinnerReturnsPlayer() {
    GameState gameState = GameState.startGame(10, 250, TEST_BOSS_STATS, false);

    gameState = gameState.playPlayerRound(POISON);
    gameState = gameState.playBossRound();
    gameState = gameState.playPlayerRound(MAGIC_MISSILE);
    gameState = gameState.playBossRound();

    Player winner = gameState.getWinner();
    assertThat(winner).isEqualTo(Player.PLAYER);
  }

  @Test
  void
      givenAGameWithTestPlayerAndABossWith14HitPoints_playAccordingToExample1_getWinnerReturnsBoss() {
    GameState gameState = GameState.startGame(10, 250, TEST_BOSS_WITH_14_HIT_POINTS, false);

    gameState = gameState.playPlayerRound(POISON);
    gameState = gameState.playBossRound();
    gameState = gameState.playPlayerRound(MAGIC_MISSILE);
    gameState = gameState.playBossRound();

    Player winner = gameState.getWinner();
    assertThat(winner).isEqualTo(Player.BOSS);
  }

  @Test
  void
      givenAGameWithTestPlayerAndABossWith14HitPoints_playAccordingToExample2_getWinnerReturnsPlayer() {
    GameState gameState = GameState.startGame(10, 250, TEST_BOSS_WITH_14_HIT_POINTS, false);

    gameState = gameState.playPlayerRound(RECHARGE);
    gameState = gameState.playBossRound();
    gameState = gameState.playPlayerRound(SHIELD);
    gameState = gameState.playBossRound();
    gameState = gameState.playPlayerRound(DRAIN);
    gameState = gameState.playBossRound();
    gameState = gameState.playPlayerRound(POISON);
    gameState = gameState.playBossRound();
    gameState = gameState.playPlayerRound(MAGIC_MISSILE);
    gameState = gameState.playBossRound();

    Player winner = gameState.getWinner();
    assertThat(winner).isEqualTo(Player.PLAYER);
  }

  @Test
  void
      givenADifficultGameWithTestPlayerAndBossStats_playAccordingToExample1_getWinnerReturnsPlayer() {
    GameState gameState = GameState.startGame(10, 250, TEST_BOSS_STATS, true);

    gameState = gameState.playPlayerRound(POISON);
    gameState = gameState.playBossRound();
    gameState = gameState.playPlayerRound(MAGIC_MISSILE);

    Player winner = gameState.getWinner();
    assertThat(winner).isEqualTo(Player.BOSS);
  }
}
