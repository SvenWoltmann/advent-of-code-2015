package eu.happycoders.adventofcode2015.day5;

import eu.happycoders.adventofcode2015.common.InputLoader;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Main application for day 5.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class Day5Main {

  public static void main(String[] args) {
    String input = InputLoader.loadInput("day5/day5input.txt");

    System.out.println(Day5Solver.solvePart1(input));
    System.out.println(Day5Solver.solvePart2(input));
  }
}
