package eu.happycoders.adventofcode2015.day21;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Finds the best strategy according to the puzzle rules.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class StrategyFinder {

  static Optional<ItemSet> findCheapestItemSetToWin(int playerHitPoints, PlayerStats bossStats) {
    List<ItemSet> playerItemSets =
        ItemSetsCompositor.generateAllPossibleItemSets(Shop.WEAPONS, Shop.ARMORS, Shop.RINGS);

    // Sort them ascending by price, so the first set to win is also the cheapest one
    playerItemSets.sort(Comparator.comparing(ItemSet::getTotalCost));

    return getFirstItemSetWithExpectedWinner(
        playerHitPoints, playerItemSets, bossStats, Player.PLAYER);
  }

  static Optional<ItemSet> findMostExpensiveItemSetToLose(
      int playerHitPoints, PlayerStats bossStats) {
    List<ItemSet> playerItemSets =
        ItemSetsCompositor.generateAllPossibleItemSets(Shop.WEAPONS, Shop.ARMORS, Shop.RINGS);

    // Sort them descending by price, so the first set to lose is also the most expensive one
    playerItemSets.sort(Comparator.comparing(ItemSet::getTotalCost).reversed());

    return getFirstItemSetWithExpectedWinner(
        playerHitPoints, playerItemSets, bossStats, Player.BOSS);
  }

  private static Optional<ItemSet> getFirstItemSetWithExpectedWinner(
      int playerHitPoints,
      List<ItemSet> playerItemSets,
      PlayerStats bossStats,
      Player expectedWinner) {
    for (ItemSet playerItemSet : playerItemSets) {
      PlayerStats playerStats = new PlayerStats(playerHitPoints, playerItemSet);

      GameSimulator gameSimulator = new GameSimulator(playerStats, bossStats);
      gameSimulator.play();

      Player winner = gameSimulator.getWinner();
      if (winner == expectedWinner) {
        return Optional.of(playerItemSet);
      }
    }

    return Optional.empty();
  }
}
