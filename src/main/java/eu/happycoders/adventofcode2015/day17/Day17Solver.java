package eu.happycoders.adventofcode2015.day17;

import java.util.List;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Puzzle solver for day 17.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class Day17Solver {

  static int solvePart1(String input, int requestedVolume) {
    List<Integer> containerSizes = PuzzleInputParser.parse(input);
    ContainerCombiner containerCombiner = new ContainerCombiner(containerSizes);
    containerCombiner.findAllPossibleCombinations(requestedVolume);
    return containerCombiner.getNumberOfCombinations();
  }

  static int solvePart2(String input, int requestedVolume) {
    List<Integer> containerSizes = PuzzleInputParser.parse(input);
    ContainerCombiner containerCombiner = new ContainerCombiner(containerSizes);
    containerCombiner.findAllPossibleCombinations(requestedVolume);
    return containerCombiner.getNumberOfCombinationsWithFewestNumberOfContainers();
  }
}
