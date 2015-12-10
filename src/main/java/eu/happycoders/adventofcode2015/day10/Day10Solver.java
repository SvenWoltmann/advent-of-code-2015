package eu.happycoders.adventofcode2015.day10;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Puzzle solver for day 10.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class Day10Solver {

  static int solvePart1(String input) {
    String temp = LookAndSay.lookAndSay(input, 40);
    return temp.length();
  }

  static int solvePart2(String input) {
    String temp = LookAndSay.lookAndSay(input, 50);
    return temp.length();
  }
}
