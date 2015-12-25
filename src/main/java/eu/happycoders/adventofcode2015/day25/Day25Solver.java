package eu.happycoders.adventofcode2015.day25;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Puzzle solver for day 25.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class Day25Solver {

  static int solve(int row, int col) {
    int elementIndex = DiagonalElementsCalculator.calculateElementIndex(row - 1, col - 1);
    return CodeGenerator.getCode(elementIndex);
  }
}
