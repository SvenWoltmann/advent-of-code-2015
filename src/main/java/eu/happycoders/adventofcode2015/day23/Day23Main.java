package eu.happycoders.adventofcode2015.day23;

import eu.happycoders.adventofcode2015.common.InputLoader;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Main application for day 23.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class Day23Main {

  public static void main(String[] args) {
    String input = InputLoader.loadInput("day23/day23input.txt");

    System.out.println(Day23Solver.solvePart1(input));
    System.out.println(Day23Solver.solvePart2(input));
  }
}
