package eu.happycoders.adventofcode2015.day9;

import java.util.List;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Puzzle solver for day 9.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class Day9Solver {

  static int solvePart1(String input) {
    List<Path> paths = PuzzleInputParser.parse(input);
    TravelingSalesmanProblemSolver tspSolver = new TravelingSalesmanProblemSolver(paths);
    tspSolver.analyzeAllRoutes();
    return tspSolver.getLengthOfShortestRoute();
  }

  static int solvePart2(String input) {
    List<Path> paths = PuzzleInputParser.parse(input);
    TravelingSalesmanProblemSolver tspSolver = new TravelingSalesmanProblemSolver(paths);
    tspSolver.analyzeAllRoutes();
    return tspSolver.getLengthOfLongestRoute();
  }
}
