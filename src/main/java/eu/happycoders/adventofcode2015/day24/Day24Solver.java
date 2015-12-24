package eu.happycoders.adventofcode2015.day24;

import java.util.List;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Puzzle solver for day 24.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class Day24Solver {

  static long solvePart1(String input) {
    List<Integer> packageWeights = PuzzleInputParser.parse(input);
    SleighBalancer sleighBalancer = new SleighBalancer(packageWeights, 3);
    return sleighBalancer.findIdealConfigurationQe();
  }

  static long solvePart2(String input) {
    List<Integer> packageWeights = PuzzleInputParser.parse(input);
    SleighBalancer sleighBalancer = new SleighBalancer(packageWeights, 4);
    return sleighBalancer.findIdealConfigurationQe();
  }
}
