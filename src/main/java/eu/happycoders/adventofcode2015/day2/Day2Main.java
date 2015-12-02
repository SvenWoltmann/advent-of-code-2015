package eu.happycoders.adventofcode2015.day2;

import eu.happycoders.adventofcode2015.common.InputLoader;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Main application for day 2.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class Day2Main {

  public static void main(String[] args) {
    String input = InputLoader.loadInput("day2/day2input.txt");

    System.out.println(Day2Solver.solvePart1(input));
    System.out.println(Day2Solver.solvePart2(input));
  }
}
