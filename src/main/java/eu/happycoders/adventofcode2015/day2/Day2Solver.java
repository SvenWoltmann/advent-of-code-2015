package eu.happycoders.adventofcode2015.day2;

import java.util.List;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Puzzle solver for day 2.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class Day2Solver {

  static int solvePart1(String input) {
    List<Dimensions> listOfDimensions = PuzzleInputParser.parse(input);

    return listOfDimensions.stream()
        .mapToInt(WrappingPaperCalculator::calculateRequiredWrappingPaperSize)
        .sum();
  }

  static int solvePart2(String input) {
    List<Dimensions> listOfDimensions = PuzzleInputParser.parse(input);

    return listOfDimensions.stream()
        .mapToInt(RibbonCalculator::calculateRequiredRibbonLength)
        .sum();
  }
}
