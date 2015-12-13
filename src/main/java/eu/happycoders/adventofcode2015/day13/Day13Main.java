package eu.happycoders.adventofcode2015.day13;

import eu.happycoders.adventofcode2015.common.InputLoader;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Main application for day 13.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class Day13Main {

  public static void main(String[] args) {
    String input = InputLoader.loadInput("day13/day13input.txt");

    System.out.println(Day13Solver.solvePart1(input));
    System.out.println(Day13Solver.solvePart2(input));
  }
}
