package eu.happycoders.adventofcode2015.day24;

import eu.happycoders.adventofcode2015.common.InputLoader;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Main application for day 24.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class Day24Main {

  public static void main(String[] args) {
    String input = InputLoader.loadInput("day24/day24input.txt");

    System.out.println(Day24Solver.solvePart1(input));
    System.out.println(Day24Solver.solvePart2(input));
  }
}
