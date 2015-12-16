package eu.happycoders.adventofcode2015.day16;

import eu.happycoders.adventofcode2015.common.InputLoader;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Main application for day 16.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class Day16Main {

  public static void main(String[] args) {
    String input = InputLoader.loadInput("day16/day16input.txt");

    System.out.println(Day16Solver.solvePart1(input));
    System.out.println(Day16Solver.solvePart2(input));
  }
}
