package eu.happycoders.adventofcode2015.common;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Loads the puzzle input from a text file.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
public class InputLoader {

  /**
   * Loads the puzzle input from the specified file.
   *
   * @param fileName the file name relative to the "adventofcode2015" package's directory.
   * @return the file contents
   */
  public static String loadInput(String fileName) {
    Path path = Paths.get("src/main/java/eu/happycoders/adventofcode2015", fileName);
    return loadFile(path);
  }

  /**
   * Loads a file from the specified path.
   *
   * @param path the path relative to the root of this project.
   * @return the file contents
   */
  public static String loadFile(Path path) {
    try {
      byte[] bytes = Files.readAllBytes(path);
      return new String(bytes, StandardCharsets.UTF_8);
    } catch (IOException e) {
      throw new UncheckedIOException(e);
    }
  }
}
