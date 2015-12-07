package eu.happycoders.adventofcode2015.day7;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Parses the input text into a list of {@link Instruction}s.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class PuzzleInputParser {

  private static final Pattern BINARY_GATE_PATTERN =
      Pattern.compile("([a-z]+|\\d+) ([A-Z]+) ([a-z]+|\\d+)");
  private static final Pattern UNARY_GATE_PATTERN = Pattern.compile("([A-Z]+) ([a-z]+|\\d+)");
  private static final Pattern WIRE_PATTERN = Pattern.compile("([a-z]+)");
  private static final Pattern SPECIFIC_VALUE_PATTERN = Pattern.compile("(\\d+)");

  static List<Instruction> parse(String input) {
    Map<String, Wire> wireMap = new HashMap<>();
    return Arrays.stream(input.split("\\r?\\n"))
        .map(line -> parseInstruction(line, wireMap))
        .collect(Collectors.toList());
  }

  static Instruction parseInstruction(String input, Map<String, Wire> wireMap) {
    String[] parts = input.split(" -> ");
    if (parts.length != 2) {
      throw new IllegalArgumentException();
    }

    WireSource wireSource = parseWireSource(parts[0], wireMap);
    String destinationWireId = parts[1];
    return new Instruction(wireSource, destinationWireId);
  }

  private static WireSource parseWireSource(String input, Map<String, Wire> wireMap) {
    WireSource wireSource = tryParseBinaryGate(input, wireMap);
    if (wireSource != null) {
      return wireSource;
    }

    wireSource = tryParseUnaryGate(input, wireMap);
    if (wireSource != null) {
      return wireSource;
    }

    return parseWireOrSpecificValue(input, wireMap);
  }

  private static BinaryGate tryParseBinaryGate(String input, Map<String, Wire> wireMap) {
    Matcher matcher = BINARY_GATE_PATTERN.matcher(input);
    if (!matcher.matches()) {
      return null;
    }

    String source1 = matcher.group(1);
    String operator = matcher.group(2);
    String source2 = matcher.group(3);

    GateInput gateInput1 = parseWireOrSpecificValue(source1, wireMap);
    GateInput gateInput2 = parseWireOrSpecificValue(source2, wireMap);

    switch (operator) {
      case "AND":
        return new AndGate(gateInput1, gateInput2);

      case "OR":
        return new OrGate(gateInput1, gateInput2);

      case "LSHIFT":
        return new LeftShiftGate(gateInput1, gateInput2);

      case "RSHIFT":
        return new RightShiftGate(gateInput1, gateInput2);

      default:
        throw new IllegalArgumentException("Unknown operator for binary gate: " + operator);
    }
  }

  private static UnaryGate tryParseUnaryGate(String input, Map<String, Wire> wireMap) {
    Matcher matcher = UNARY_GATE_PATTERN.matcher(input);
    if (!matcher.matches()) {
      return null;
    }

    String operator = matcher.group(1);
    String source = matcher.group(2);

    GateInput gateInput = parseWireOrSpecificValue(source, wireMap);

    if (operator.equals("NOT")) {
      return new NotGate(gateInput);
    }

    throw new IllegalArgumentException("Unknown operator for unary gate: " + operator);
  }

  private static GateInput parseWireOrSpecificValue(String input, Map<String, Wire> wireMap) {
    Matcher matcher = WIRE_PATTERN.matcher(input);
    if (matcher.matches()) {
      String wireId = matcher.group(1);
      return wireMap.computeIfAbsent(wireId, ignore -> new Wire(wireId));
    }

    matcher = SPECIFIC_VALUE_PATTERN.matcher(input);
    if (matcher.matches()) {
      int signal = Integer.parseInt(matcher.group(1));
      return new SpecificValue(signal);
    }

    throw new IllegalArgumentException(input);
  }
}
