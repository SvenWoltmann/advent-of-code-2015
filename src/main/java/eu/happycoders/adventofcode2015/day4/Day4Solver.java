package eu.happycoders.adventofcode2015.day4;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Puzzle solver for day 4.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class Day4Solver {

  static int solvePart1(String input) {
    return Miner.mine(input, 5);
  }

  static int solvePart2(String input) {
    return Miner.mine(input, 6);
  }
}
