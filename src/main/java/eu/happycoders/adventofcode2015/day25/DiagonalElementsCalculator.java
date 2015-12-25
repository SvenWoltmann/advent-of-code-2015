package eu.happycoders.adventofcode2015.day25;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Calculates the element index at a given row and column on an infinite sheet of paper.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class DiagonalElementsCalculator {

  static int calculateElementIndex(int row, int col) {
    int diagonalNumber = row + col;
    int diagonalStart = diagonalNumber * (diagonalNumber + 1) / 2;
    return diagonalStart + col;
  }
}
