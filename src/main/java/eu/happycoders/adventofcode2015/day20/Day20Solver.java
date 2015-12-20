package eu.happycoders.adventofcode2015.day20;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Puzzle solver for day 20.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class Day20Solver {

  static int solvePart1(int input) {
    return ElfDivisorFunctions.findLowestHouseNoForSumOfPresents(input, Integer.MAX_VALUE, 10);
  }

  static int solvePart2(int input) {
    return ElfDivisorFunctions.findLowestHouseNoForSumOfPresents(input, 50, 11);
  }
}
