package eu.happycoders.adventofcode2015.day22;

import eu.happycoders.adventofcode2015.common.InputLoader;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Main application for day 22.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class Day22Main {

  public static void main(String[] args) {
    String input = InputLoader.loadInput("day22/day22input.txt");

    System.out.println(Day22Solver.solvePart1(input));
    System.out.println(Day22Solver.solvePart2(input));
  }
}
