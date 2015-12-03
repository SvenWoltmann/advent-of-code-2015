package eu.happycoders.adventofcode2015.day3;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Puzzle solver for day 3.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class Day3Solver {

  static int solvePart1(String input) {
    List<Direction> directions = PuzzleInputParser.parse(input);
    SantaSimulator simulator = new SantaSimulator();
    for (Direction direction : directions) {
      simulator.goTo(direction);
    }
    return simulator.getDeliveredLocations().size();
  }

  static int solvePart2(String input) {
    List<Direction> directions = PuzzleInputParser.parse(input);
    SantaSimulator santaSimulator = new SantaSimulator();
    SantaSimulator roboSimulator = new SantaSimulator();

    for (Iterator<Direction> iterator = directions.iterator(); iterator.hasNext(); ) {
      Direction direction = iterator.next();
      santaSimulator.goTo(direction);

      if (iterator.hasNext()) {
        roboSimulator.goTo(iterator.next());
      }
    }

    Set<Location> allDeliveredLocations = new HashSet<>();
    allDeliveredLocations.addAll(santaSimulator.getDeliveredLocations());
    allDeliveredLocations.addAll(roboSimulator.getDeliveredLocations());
    return allDeliveredLocations.size();
  }
}
