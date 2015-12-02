package eu.happycoders.adventofcode2015.day2;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

class PuzzleInputParser {

  private static final Pattern PATTERN = Pattern.compile("(\\d+)x(\\d+)x(\\d+)");

  static List<Dimensions> parse(String input) {
    return Arrays.stream(input.split("\\r?\\n"))
        .map(PuzzleInputParser::parseDimensions)
        .collect(Collectors.toList());
  }

  private static Dimensions parseDimensions(String input) {
    Matcher matcher = PATTERN.matcher(input);
    if (!matcher.matches()) {
      throw new IllegalArgumentException(input);
    }
    int length = Integer.parseInt(matcher.group(1));
    int width = Integer.parseInt(matcher.group(2));
    int height = Integer.parseInt(matcher.group(3));
    return new Dimensions(length, width, height);
  }
}
