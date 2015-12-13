package eu.happycoders.adventofcode2015.day13;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Parses the input text into a list of {@link PotentialHappiness}es.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class PuzzleInputParser {

  private static final Pattern PATTERN =
      Pattern.compile(
          "([A-Za-z]+) would (gain|lose) (\\d+) happiness units by sitting next to ([A-Za-z]+).");

  static List<PotentialHappiness> parse(String input) {
    return Arrays.stream(input.split("\\r?\\n"))
        .map(PuzzleInputParser::parsePotentialHappiness)
        .collect(Collectors.toList());
  }

  private static PotentialHappiness parsePotentialHappiness(String input) {
    Matcher matcher = PATTERN.matcher(input);
    if (!matcher.matches()) {
      throw new IllegalArgumentException(input);
    }

    String person = matcher.group(1);
    String operation = matcher.group(2);
    int happinessPoints = Integer.parseInt(matcher.group(3));
    String neighbor = matcher.group(4);

    PersonAndNeighbor personAndNeighbor = new PersonAndNeighbor(person, neighbor);

    switch (operation) {
      case "gain":
        return new PotentialHappiness(personAndNeighbor, happinessPoints);

      case "lose":
        return new PotentialHappiness(personAndNeighbor, -happinessPoints);

      default:
        throw new IllegalArgumentException(input);
    }
  }
}
