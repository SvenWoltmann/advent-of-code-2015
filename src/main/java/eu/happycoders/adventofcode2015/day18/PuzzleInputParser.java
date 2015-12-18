package eu.happycoders.adventofcode2015.day18;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Parses the input text into a two-dimensional boolean array indicating the lit lights.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class PuzzleInputParser {

  static boolean[][] parse(String input) {
    String[] lines = input.split("\\r?\\n");
    int height = lines.length;
    int width = lines[0].length();
    boolean[][] litLights = new boolean[height][width];
    for (int y = 0; y < height; y++) {
      String line = lines[y];
      for (int x = 0; x < width; x++) {
        litLights[y][x] = line.charAt(x) == '#';
      }
    }
    return litLights;
  }
}
