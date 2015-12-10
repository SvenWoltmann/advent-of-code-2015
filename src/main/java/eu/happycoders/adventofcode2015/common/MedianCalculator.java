package eu.happycoders.adventofcode2015.common;

import java.util.Collections;
import java.util.List;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Median calculator (used for measuring the performance of algorithms).
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
public class MedianCalculator {

  /**
   * Calculates the median of the given values.
   *
   * @param values the values to calculate the median from
   * @return the median
   */
  public static long calculateMedian(List<Long> values) {
    if (values.isEmpty()) {
      throw new IllegalArgumentException("List is empty");
    }

    Collections.sort(values);

    int size = values.size();
    int half = size / 2;

    if (size % 2 == 0) {
      return (values.get(half - 1) + values.get(half)) / 2;
    } else {
      return values.get(half);
    }
  }
}
