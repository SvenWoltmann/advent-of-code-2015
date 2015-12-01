package eu.happycoders.adventofcode2015.day1;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Puzzle solver for day 1.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class Day1Solver {

  static int solvePart1(String input) {
    Instructions instructions = new Instructions(input);
    SantaSimulator santaSimulator = new SantaSimulator(instructions);
    while (santaSimulator.hasNextInstruction()) {
      santaSimulator.executeNextInstruction();
    }
    return santaSimulator.getFloor();
  }

  static int solvePart2(String input) {
    Instructions instructions = new Instructions(input);
    SantaSimulator santaSimulator = new SantaSimulator(instructions);
    int numberOfInstructions = 0;
    while (santaSimulator.getFloor() != -1) {
      santaSimulator.executeNextInstruction();
      numberOfInstructions++;
    }
    return numberOfInstructions;
  }
}
