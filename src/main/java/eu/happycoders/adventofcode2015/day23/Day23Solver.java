package eu.happycoders.adventofcode2015.day23;

import java.util.List;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Puzzle solver for day 23.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class Day23Solver {

  static int solvePart1(String input) {
    List<Instruction> instructions = PuzzleInputParser.parse(input);

    CpuEmulator cpuEmulator = new CpuEmulator(instructions);
    cpuEmulator.run();

    return cpuEmulator.getRegisterB();
  }

  static int solvePart2(String input) {
    List<Instruction> instructions = PuzzleInputParser.parse(input);

    CpuEmulator cpuEmulator = new CpuEmulator(instructions);
    cpuEmulator.setRegisterA(1);
    cpuEmulator.run();

    return cpuEmulator.getRegisterB();
  }
}
