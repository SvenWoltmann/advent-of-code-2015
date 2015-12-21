package eu.happycoders.adventofcode2015.day21;

import static eu.happycoders.adventofcode2015.day21.Player.BOSS;
import static eu.happycoders.adventofcode2015.day21.Player.PLAYER;
import static java.lang.Math.max;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Simulator for the game.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class GameSimulator {

  private final PlayerStats playerStats;
  private final PlayerStats bossStats;

  private Player winner;

  GameSimulator(PlayerStats playerStats, PlayerStats bossStats) {
    this.playerStats = playerStats;
    this.bossStats = bossStats;
  }

  void play() {
    int playerHitPoints = playerStats.hitPoints();
    int bossHitPoints = bossStats.hitPoints();

    Player currentPlayer = PLAYER;

    while (playerHitPoints > 0 && bossHitPoints > 0) {
      if (currentPlayer == PLAYER) {
        int damage = max(playerStats.damage() - bossStats.armor(), 1);
        bossHitPoints -= damage;
        currentPlayer = BOSS;
      } else {
        int damage = max(bossStats.damage() - playerStats.armor(), 1);
        playerHitPoints -= damage;
        currentPlayer = PLAYER;
      }
    }

    winner = playerHitPoints > 0 ? PLAYER : BOSS;
  }

  Player getWinner() {
    return winner;
  }
}
