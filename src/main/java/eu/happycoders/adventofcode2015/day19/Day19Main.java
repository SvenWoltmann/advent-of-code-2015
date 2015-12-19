package eu.happycoders.adventofcode2015.day19;

import eu.happycoders.adventofcode2015.common.InputLoader;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Main application for day 19.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class Day19Main {

  public static void main(String[] args) {
    String input = InputLoader.loadInput("day19/day19input.txt");

    System.out.println(Day19Solver.solvePart1(input));
    System.out.println(Day19Solver.solvePart2(input));
  }
}
