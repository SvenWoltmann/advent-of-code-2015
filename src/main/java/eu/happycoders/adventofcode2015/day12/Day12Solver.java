package eu.happycoders.adventofcode2015.day12;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Puzzle solver for day 12.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class Day12Solver {

  static int solvePart1(String input) {
    return JsonAnalyzer.getSumOfAllNumbers(input);
  }

  static int solvePart2(String input) {
    return JsonAnalyzer.getSumOfAllNonRedNumbers(input);
  }
}
