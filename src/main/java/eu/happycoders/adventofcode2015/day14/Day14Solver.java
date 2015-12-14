package eu.happycoders.adventofcode2015.day14;

import java.util.List;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Puzzle solver for day 14.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class Day14Solver {

  static int solvePart1(String input) {
    List<Reindeer> reindeer = PuzzleInputParser.parse(input);
    ReindeerOlympics olympics = new ReindeerOlympics(reindeer);
    return olympics.getFarthestDistanceAfterSeconds(2503);
  }

  static int solvePart2(String input) {
    List<Reindeer> reindeer = PuzzleInputParser.parse(input);
    ReindeerOlympics olympics = new ReindeerOlympics(reindeer);
    return olympics.getMostPointsAfterSeconds(2503);
  }
}
