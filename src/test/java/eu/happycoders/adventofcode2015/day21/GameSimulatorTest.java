package eu.happycoders.adventofcode2015.day21;

import static eu.happycoders.adventofcode2015.day21.TestInputs.TEST_BOSS_STATS;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class GameSimulatorTest {

  private static final PlayerStats TEST_PLAYER_STATS = new PlayerStats(8, 5, 5);

  @Test
  void givenAGameSimulatorWithTestPlayerAndBossStats_play_getWinnerReturnsPlayer() {
    GameSimulator gameSimulator = new GameSimulator(TEST_PLAYER_STATS, TEST_BOSS_STATS);

    gameSimulator.play();

    Player winner = gameSimulator.getWinner();
    assertThat(winner).isEqualTo(Player.PLAYER);
  }
}
