package eu.happycoders.adventofcode2015.day18;

import eu.happycoders.adventofcode2015.common.InputLoader;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Main application for day 18.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class Day18Main {

  public static void main(String[] args) {
    String input = InputLoader.loadInput("day18/day18input.txt");

    System.out.println(Day18Solver.solvePart1(input));
    System.out.println(Day18Solver.solvePart2(input));
  }
}
