package eu.happycoders.adventofcode2015.day7;

import java.util.List;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Puzzle solver for day 7.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class Day7Solver {

  static int solvePart1(String input) {
    List<Instruction> instructions = PuzzleInputParser.parse(input);
    CircuitSimulator circuitSimulator = new CircuitSimulator(instructions);
    return circuitSimulator.getSignalOnWire("a");
  }

  static int solvePart2(String input) {
    List<Instruction> instructions = PuzzleInputParser.parse(input);
    CircuitSimulator circuitSimulator = new CircuitSimulator(instructions);
    int signalA = circuitSimulator.getSignalOnWire("a");

    circuitSimulator.putInstruction(new Instruction(new SpecificValue(signalA), "b"));
    circuitSimulator.resetAllWires();
    return circuitSimulator.getSignalOnWire("a");
  }
}
