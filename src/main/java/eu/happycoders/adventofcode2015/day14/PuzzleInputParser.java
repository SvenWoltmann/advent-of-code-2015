package eu.happycoders.adventofcode2015.day14;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Parses the input text into a list of {@link Reindeer}.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class PuzzleInputParser {

  private static final Pattern PATTERN =
      Pattern.compile(
          "([A-Za-z]+) can fly (\\d+) km/s for (\\d+) seconds, "
              + "but then must rest for (\\d+) seconds.");

  static List<Reindeer> parse(String input) {
    return Arrays.stream(input.split("\\r?\\n"))
        .map(PuzzleInputParser::parseReindeer)
        .collect(Collectors.toList());
  }

  private static Reindeer parseReindeer(String input) {
    Matcher matcher = PATTERN.matcher(input);
    if (!matcher.matches()) {
      throw new IllegalArgumentException(input);
    }

    String name = matcher.group(1);
    int airspeed = Integer.parseInt(matcher.group(2));
    int maxFlightDuration = Integer.parseInt(matcher.group(3));
    int restDuration = Integer.parseInt(matcher.group(4));

    return new Reindeer(name, airspeed, maxFlightDuration, restDuration);
  }
}
