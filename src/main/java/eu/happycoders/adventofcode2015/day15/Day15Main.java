package eu.happycoders.adventofcode2015.day15;

import eu.happycoders.adventofcode2015.common.InputLoader;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Main application for day 15.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class Day15Main {

  public static void main(String[] args) {
    String input = InputLoader.loadInput("day15/day15input.txt");

    System.out.println(Day15Solver.solvePart1(input));
    System.out.println(Day15Solver.solvePart2(input));
  }
}
