package eu.happycoders.adventofcode2015.day14;

import eu.happycoders.adventofcode2015.common.InputLoader;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Main application for day 14.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class Day14Main {

  public static void main(String[] args) {
    String input = InputLoader.loadInput("day14/day14input.txt");

    System.out.println(Day14Solver.solvePart1(input));
    System.out.println(Day14Solver.solvePart2(input));
  }
}
