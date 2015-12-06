package eu.happycoders.adventofcode2015.day6;

import java.util.Arrays;
import java.util.List;
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

  private static final Pattern PATTERN =
      Pattern.compile("(.*) (\\d+),(\\d+) through (\\d+),(\\d+)");

  static List<Instruction> parse(String input) {
    String[] split = input.split("\\r?\\n");
    return Arrays.stream(split)
        .map(PuzzleInputParser::parseInstruction)
        .collect(Collectors.toList());
  }

  private static Instruction parseInstruction(String input) {
    Matcher matcher = PATTERN.matcher(input);
    if (!matcher.matches()) {
      throw new IllegalArgumentException();
    }

    Command command = Command.parse(matcher.group(1));

    int startX = Integer.parseInt(matcher.group(2));
    int startY = Integer.parseInt(matcher.group(3));
    int endX = Integer.parseInt(matcher.group(4));
    int endY = Integer.parseInt(matcher.group(5));

    return new Instruction(command, new Position(startX, startY), new Position(endX, endY));
  }
}
