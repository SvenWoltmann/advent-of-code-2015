package eu.happycoders.adventofcode2015.day5;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Puzzle solver for day 5.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class Day5Solver {

  static int solvePart1(String input) {
    return NiceStringCounter.countNiceStrings(input, new NiceStringDetectorPart1());
  }

  static int solvePart2(String input) {
    return NiceStringCounter.countNiceStrings(input, new NiceStringDetectorPart2());
  }
}
