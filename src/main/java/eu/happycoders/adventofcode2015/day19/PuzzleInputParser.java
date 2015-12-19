package eu.happycoders.adventofcode2015.day19;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Parses the input text into a {@link PuzzleInput}: a list of {@link Replacement}s and a {@link
 * Molecule}.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class PuzzleInputParser {

  private static final Pattern PATTERN = Pattern.compile("([A-Za-z]+) => ([A-Za-z]+)");

  static PuzzleInput parse(String input) {
    String[] parts = input.split("\\r?\\n\\r?\\n");
    String replacementsInput = parts[0];
    String moleculeValue = parts[1];

    List<Replacement> replacements = parseReplacements(replacementsInput);
    Molecule molecule = new Molecule(moleculeValue);

    return new PuzzleInput(replacements, molecule);
  }

  private static List<Replacement> parseReplacements(String input) {
    return Arrays.stream(input.split("\\r?\\n"))
        .map(PuzzleInputParser::parseReplacement)
        .collect(Collectors.toList());
  }

  private static Replacement parseReplacement(String input) {
    Matcher matcher = PATTERN.matcher(input);
    if (!matcher.matches()) {
      throw new IllegalArgumentException(input);
    }
    String from = matcher.group(1);
    String to = matcher.group(2);
    return new Replacement(from, to);
  }
}
