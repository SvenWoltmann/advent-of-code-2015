package eu.happycoders.adventofcode2015.day6;

import eu.happycoders.adventofcode2015.common.InputLoader;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Main application for day 6.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class Day6Main {

  public static void main(String[] args) {
    String input = InputLoader.loadInput("day6/day6input.txt");

    System.out.println(Day6Solver.solvePart1(input));
    System.out.println(Day6Solver.solvePart2(input));
  }
}
