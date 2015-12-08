package eu.happycoders.adventofcode2015.day8;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Puzzle solver for day 8.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class Day8Solver {

  static int solvePart1(String input) {
    int result = 0;
    String[] lines = input.split("\\r?\\n");
    for (String line : lines) {
      int escapedAndQuotedLength = line.length();
      int inMemoryLength = StringEscaper.unquoteAndUnescape(line).length();
      int diff = escapedAndQuotedLength - inMemoryLength;
      result += diff;
    }
    return result;
  }

  static int solvePart2(String input) {
    int result = 0;
    String[] lines = input.split("\\r?\\n");
    for (String line : lines) {
      int inMemoryLength = line.length();
      int escapedAndQuotedLength = StringEscaper.escapeAndQuote(line).length();
      int diff = escapedAndQuotedLength - inMemoryLength;
      result += diff;
    }
    return result;
  }
}
