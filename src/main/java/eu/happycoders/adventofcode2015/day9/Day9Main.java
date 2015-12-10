package eu.happycoders.adventofcode2015.day9;

import eu.happycoders.adventofcode2015.common.InputLoader;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Main application for day 9.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class Day9Main {

  public static void main(String[] args) {
    String input = InputLoader.loadInput("day9/day9input.txt");

    System.out.println(Day9Solver.solvePart1(input));
    System.out.println(Day9Solver.solvePart2(input));
  }
}
