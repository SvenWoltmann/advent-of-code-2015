package eu.happycoders.adventofcode2015.day13;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Puzzle solver for day 13.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class Day13Solver {

  static int solvePart1(String input) {
    List<PotentialHappiness> potentialHappinesses = PuzzleInputParser.parse(input);
    OptimalSeatingArrangementCalculator optimalSeatingArrangementCalculator =
        new OptimalSeatingArrangementCalculator(potentialHappinesses);
    return optimalSeatingArrangementCalculator.calculateOptimalSeatingArrangement();
  }

  static int solvePart2(String input) {
    List<PotentialHappiness> potentialHappinesses = PuzzleInputParser.parse(input);
    addSelf(potentialHappinesses);
    OptimalSeatingArrangementCalculator optimalSeatingArrangementCalculator =
        new OptimalSeatingArrangementCalculator(potentialHappinesses);
    optimalSeatingArrangementCalculator.calculateOptimalSeatingArrangement();
    return optimalSeatingArrangementCalculator.calculateOptimalSeatingArrangement();
  }

  private static void addSelf(List<PotentialHappiness> potentialHappinesses) {
    Set<String> persons =
        potentialHappinesses.stream()
            .map(potentialHappiness -> potentialHappiness.personAndNeighbor().person())
            .collect(Collectors.toSet());

    for (String person : persons) {
      potentialHappinesses.add(new PotentialHappiness(new PersonAndNeighbor("self", person), 0));
      potentialHappinesses.add(new PotentialHappiness(new PersonAndNeighbor(person, "self"), 0));
    }
  }
}
