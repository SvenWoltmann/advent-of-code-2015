package eu.happycoders.adventofcode2015.day5;

import java.util.function.Predicate;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Detector for nice/naughty strings (part 1).
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class NiceStringDetectorPart1 implements Predicate<String> {

  @Override
  public boolean test(String string) {
    int vowelCount = 0;
    boolean pairExists = false;

    char lastCharacter = ' ';
    for (int i = 0; i < string.length(); i++) {
      char character = string.charAt(i);
      if (isVowel(character)) {
        vowelCount++;
      }
      if (i > 0 && character == lastCharacter) {
        pairExists = true;
      }
      if (i > 0 && isBadPair(lastCharacter, character)) {
        return false;
      }
      lastCharacter = character;
    }

    return vowelCount >= 3 && pairExists;
  }

  private static boolean isVowel(char character) {
    return character == 'a'
        || character == 'e'
        || character == 'i'
        || character == 'o'
        || character == 'u';
  }

  private static boolean isBadPair(char lastCharacter, char character) {
    return (lastCharacter == 'a'
            || lastCharacter == 'c'
            || lastCharacter == 'p'
            || lastCharacter == 'x')
        && character == lastCharacter + 1;
  }
}
