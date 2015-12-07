package eu.happycoders.adventofcode2015.day7;

import eu.happycoders.adventofcode2015.common.InputLoader;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Main application for day 7.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class Day7Main {

  public static void main(String[] args) {
    String input = InputLoader.loadInput("day7/day7input.txt");

    System.out.println(Day7Solver.solvePart1(input));
    System.out.println(Day7Solver.solvePart2(input));
  }
}
