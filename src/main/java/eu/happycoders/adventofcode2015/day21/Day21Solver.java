package eu.happycoders.adventofcode2015.day21;

import java.util.Optional;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Puzzle solver for day 21.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class Day21Solver {

  static int solvePart1(String input) {
    PlayerStats bossStats = PuzzleInputParser.parse(input);
    Optional<ItemSet> itemSet = StrategyFinder.findCheapestItemSetToWin(100, bossStats);
    return itemSet.orElseThrow(AssertionError::new).getTotalCost();
  }

  static int solvePart2(String input) {
    PlayerStats bossStats = PuzzleInputParser.parse(input);
    Optional<ItemSet> itemSet = StrategyFinder.findMostExpensiveItemSetToLose(100, bossStats);
    return itemSet.orElseThrow(AssertionError::new).getTotalCost();
  }
}
