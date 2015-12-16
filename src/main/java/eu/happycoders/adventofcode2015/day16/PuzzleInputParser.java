package eu.happycoders.adventofcode2015.day16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Parses the input text into a list of {@link Sue}s.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class PuzzleInputParser {

  // A repeated capturing group will only capture the last iteration.
  // Therefore, we cannot capture multiple properties with one regex.
  private static final Pattern PATTERN = Pattern.compile("Sue (\\d+): (.*)");

  static List<Sue> parse(String input) {
    return Arrays.stream(input.split("\\r?\\n"))
        .map(PuzzleInputParser::parseSue)
        .collect(Collectors.toList());
  }

  private static Sue parseSue(String input) {
    Matcher matcher = PATTERN.matcher(input);
    if (!matcher.matches()) {
      throw new IllegalArgumentException(input);
    }

    int number = Integer.parseInt(matcher.group(1));
    String propertiesString = matcher.group(2);

    List<SueProperty> properties = parseProperties(propertiesString);

    return new Sue(number, properties);
  }

  private static List<SueProperty> parseProperties(String input) {
    List<SueProperty> result = new ArrayList<>();

    String[] propertyStrings = input.split(", ");
    for (String propertyString : propertyStrings) {
      String[] propertyStringParts = propertyString.split(": ");
      String name = propertyStringParts[0];
      int value = Integer.parseInt(propertyStringParts[1]);
      result.add(new SueProperty(name, value));
    }

    return result;
  }
}
