package eu.happycoders.adventofcode2015.day11;

import static eu.happycoders.adventofcode2015.day11.PasswordGenerator.findNextSecurePassword;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Puzzle solver for day 11.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class Day11Solver {

  static String solvePart1(String input) {
    return findNextSecurePassword(input);
  }

  static String solvePart2(String input) {
    return findNextSecurePassword(findNextSecurePassword(input));
  }
}
