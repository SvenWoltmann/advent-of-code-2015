package eu.happycoders.adventofcode2015.day5;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Detector for nice/naughty strings (part 2).
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class NiceStringDetectorPart2 implements Predicate<String> {

  @Override
  public boolean test(String string) {
    Map<String, Integer> twoLetterPairToFirstPosition = new HashMap<>();
    boolean foundTwoLetterPairTwice = false;
    boolean foundRepeatingLetterWithOneBetween = false;

    for (int i = 0; i < string.length(); i++) {
      if (!foundTwoLetterPairTwice
          && isRepeatedTwoLetterPair(string, i, twoLetterPairToFirstPosition)) {
        foundTwoLetterPairTwice = true;
      }

      if (!foundRepeatingLetterWithOneBetween && isRepeatingLetterAt(string, i)) {
        foundRepeatingLetterWithOneBetween = true;
      }
    }

    return foundTwoLetterPairTwice && foundRepeatingLetterWithOneBetween;
  }

  private boolean isRepeatedTwoLetterPair(
      String string, int position, Map<String, Integer> twoLetterPairToFirstPosition) {
    if (position == 0) {
      return false;
    }

    String twoLetterPair = string.substring(position - 1, position + 1);

    Integer firstPosition = twoLetterPairToFirstPosition.get(twoLetterPair);
    if (firstPosition != null) {
      int distance = position - firstPosition;
      return distance > 1;
    } else {
      twoLetterPairToFirstPosition.put(twoLetterPair, position);
      return false;
    }
  }

  private static boolean isRepeatingLetterAt(String string, int position) {
    return position > 1 && string.charAt(position - 2) == string.charAt(position);
  }
}
