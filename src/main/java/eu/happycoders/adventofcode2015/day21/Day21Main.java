package eu.happycoders.adventofcode2015.day21;

import eu.happycoders.adventofcode2015.common.InputLoader;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Main application for day 21.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class Day21Main {

  public static void main(String[] args) {
    String input = InputLoader.loadInput("day21/day21input.txt");

    System.out.println(Day21Solver.solvePart1(input));
    System.out.println(Day21Solver.solvePart2(input));
  }
}
