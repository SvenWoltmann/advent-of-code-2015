package eu.happycoders.adventofcode2015.day6;

import java.util.List;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Puzzle solver for day 6.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class Day6Solver {

  static int solvePart1(String input) {
    List<Instruction> instructions = PuzzleInputParser.parse(input);
    Grid grid = new Grid();
    grid.apply(instructions, CommandTranslator.PART_1_TRANSLATOR);
    return grid.calculateTotalBrightness();
  }

  static int solvePart2(String input) {
    List<Instruction> instructions = PuzzleInputParser.parse(input);
    Grid grid = new Grid();
    grid.apply(instructions, CommandTranslator.PART_2_TRANSLATOR);
    return grid.calculateTotalBrightness();
  }
}
