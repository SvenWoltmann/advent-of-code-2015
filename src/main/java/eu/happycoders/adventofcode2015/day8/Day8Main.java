package eu.happycoders.adventofcode2015.day8;

import eu.happycoders.adventofcode2015.common.InputLoader;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Main application for day 8.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class Day8Main {

  public static void main(String[] args) {
    String input = InputLoader.loadInput("day8/day8input.txt");

    System.out.println(Day8Solver.solvePart1(input));
    System.out.println(Day8Solver.solvePart2(input));
  }
}
