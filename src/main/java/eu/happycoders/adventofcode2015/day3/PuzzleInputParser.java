package eu.happycoders.adventofcode2015.day3;

import java.util.ArrayList;
import java.util.List;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Parses the input text into a list of {@link Direction}s.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class PuzzleInputParser {

  static List<Direction> parse(String input) {
    List<Direction> result = new ArrayList<>();
    for (int i = 0; i < input.length(); i++) {
      result.add(Direction.of(input.charAt(i)));
    }
    return result;
  }
}
