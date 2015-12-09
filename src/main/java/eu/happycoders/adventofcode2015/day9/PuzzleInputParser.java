package eu.happycoders.adventofcode2015.day9;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Parses the input text into a list of {@link Path}s.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class PuzzleInputParser {

  private static final Pattern PATTERN = Pattern.compile("([A-Za-z]+) to ([A-Za-z]+) = (\\d+)");

  static List<Path> parse(String input) {
    return Arrays.stream(input.split("\\r?\\n"))
        .map(PuzzleInputParser::parseDistance)
        .collect(Collectors.toList());
  }

  private static Path parseDistance(String input) {
    Matcher matcher = PATTERN.matcher(input);
    if (!matcher.matches()) {
      throw new IllegalArgumentException(input);
    }

    String source = matcher.group(1);
    String destination = matcher.group(2);
    int distance = Integer.parseInt(matcher.group(3));

    return new Path(source, destination, distance);
  }
}
