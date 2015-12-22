package eu.happycoders.adventofcode2015.day22;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Parses the input text into {@link PlayerStats}.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class PuzzleInputParser {

  private static final Pattern PATTERN = Pattern.compile("Hit Points: (\\d+)\\r?\\nDamage: (\\d+)");

  static PlayerStats parse(String input) {
    Matcher matcher = PATTERN.matcher(input);
    if (!matcher.matches()) {
      throw new IllegalArgumentException(input);
    }
    int hitPoints = Integer.parseInt(matcher.group(1));
    int damage = Integer.parseInt(matcher.group(2));
    return new PlayerStats(hitPoints, damage);
  }
}
