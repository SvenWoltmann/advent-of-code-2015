package eu.happycoders.adventofcode2015.day17;

import eu.happycoders.adventofcode2015.common.InputLoader;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Main application for day 17.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class Day17Main {

  public static void main(String[] args) {
    String input = InputLoader.loadInput("day17/day17input.txt");

    System.out.println(Day17Solver.solvePart1(input, 150));
    System.out.println(Day17Solver.solvePart2(input, 150));
  }
}
