package eu.happycoders.adventofcode2015.day18;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Puzzle solver for day 18.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class Day18Solver {

  static int solvePart1(String input) {
    boolean[][] litLights = PuzzleInputParser.parse(input);
    Grid grid = new Grid(litLights);
    grid.nextSteps(100);
    return grid.countLitLights();
  }

  static int solvePart2(String input) {
    boolean[][] litLights = PuzzleInputParser.parse(input);
    Grid grid = new Grid(litLights);
    grid.setCornerLightsAlwaysOn(true);
    grid.nextSteps(100);
    return grid.countLitLights();
  }
}
