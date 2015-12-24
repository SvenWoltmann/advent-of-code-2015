package eu.happycoders.adventofcode2015.day24;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Parses the puzzle input into a list of integers.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class PuzzleInputParser {

  static List<Integer> parse(String input) {
    return Arrays.stream(input.split("\\r?\\n")).map(Integer::valueOf).collect(Collectors.toList());
  }
}
