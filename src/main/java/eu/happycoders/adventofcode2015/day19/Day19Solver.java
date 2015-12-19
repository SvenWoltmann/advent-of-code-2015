package eu.happycoders.adventofcode2015.day19;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Puzzle solver for day 19.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class Day19Solver {

  static int solvePart1(String input) {
    PuzzleInput puzzleInput = PuzzleInputParser.parse(input);

    NuclearPlant nuclearPlant = new NuclearPlant(puzzleInput.replacements());

    return nuclearPlant.countDistinctMoleculesAfterOneReplacement(puzzleInput.molecule());
  }

  static int solvePart2(String input) {
    PuzzleInput puzzleInput = PuzzleInputParser.parse(input);

    NuclearPlant nuclearPlant = new NuclearPlant(puzzleInput.replacements());

    return nuclearPlant.getFewestNumberOfStepsToCreate(puzzleInput.molecule());
  }
}
