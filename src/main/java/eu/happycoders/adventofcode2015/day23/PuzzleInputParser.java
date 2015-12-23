package eu.happycoders.adventofcode2015.day23;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Parses the program code into a list of {@link Instruction}s.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class PuzzleInputParser {

  static List<Instruction> parse(String input) {
    return Arrays.stream(input.split("\\r?\\n"))
        .map(PuzzleInputParser::parseInstruction)
        .collect(Collectors.toList());
  }

  private static Instruction parseInstruction(String instruction) {
    String operationName = instruction.substring(0, 3);
    switch (operationName) {
      case "hlf":
        return new HalfInstruction(getRegisterName(instruction));
      case "tpl":
        return new TripleInstruction(getRegisterName(instruction));
      case "inc":
        return new IncInstruction(getRegisterName(instruction));
      case "jmp":
        return new JumpInstruction(getFirstParameterOffset(instruction));
      case "jie":
        return new JumpIfEvenInstruction(
            getRegisterName(instruction), getSecondParameterOffset(instruction));
      case "jio":
        return new JumpIfOneInstruction(
            getRegisterName(instruction), getSecondParameterOffset(instruction));
      default:
        return new UnknownInstruction();
    }
  }

  private static RegisterName getRegisterName(String instruction) {
    char register = instruction.charAt(4);
    switch (register) {
      case 'a':
        return RegisterName.A;
      case 'b':
        return RegisterName.B;
      default:
        throw new IllegalArgumentException(
            "Invalid register name '" + register + "' in instruction '" + instruction + "'");
    }
  }

  private static int getFirstParameterOffset(String instruction) {
    String parameter = instruction.substring(4);
    return Integer.parseInt(parameter);
  }

  @SuppressWarnings("PMD.AvoidLiteralsInIfCondition") // The meaning of the '+' is clear
  private static int getSecondParameterOffset(String instruction) {
    int index = 7;
    if (instruction.charAt(index) == '+') {
      index++;
    }
    String parameter = instruction.substring(index);
    return Integer.parseInt(parameter);
  }
}
