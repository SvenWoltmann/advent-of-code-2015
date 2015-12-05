package eu.happycoders.adventofcode2015.day5;

import java.util.Arrays;
import java.util.function.Predicate;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Counter for nice/naughty strings.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class NiceStringCounter {

  static int countNiceStrings(String input, Predicate<String> niceStringDetector) {
    return (int) Arrays.stream(input.split("\\r?\\n")).filter(niceStringDetector).count();
  }
}
