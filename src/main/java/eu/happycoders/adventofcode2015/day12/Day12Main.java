package eu.happycoders.adventofcode2015.day12;

import eu.happycoders.adventofcode2015.common.InputLoader;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Main application for day 12.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class Day12Main {

  public static void main(String[] args) {
    String input = InputLoader.loadInput("day12/day12input.txt");

    System.out.println(Day12Solver.solvePart1(input));
    System.out.println(Day12Solver.solvePart2(input));
  }
}
