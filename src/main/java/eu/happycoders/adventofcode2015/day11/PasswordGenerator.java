package eu.happycoders.adventofcode2015.day11;

import static eu.happycoders.adventofcode2015.day11.PasswordSecurityChecker.isNotAllowedCharacter;
import static eu.happycoders.adventofcode2015.day11.PasswordSecurityChecker.isSecure;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>The generator for the next secure password.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
@SuppressWarnings("PMD.AvoidLiteralsInIfCondition") // The literals' meaning is always clear
class PasswordGenerator {

  static String findNextSecurePassword(String lastPassword) {
    // Working internally with a character array speeds up the process by factor 3.4
    char[] passwordCharacters = lastPassword.toCharArray();

    // This reduces the time by factor 1,000!
    incrementToNextPasswordObeyingRuleTwo(passwordCharacters);

    do {
      increment(passwordCharacters);
    } while (!isSecure(passwordCharacters));

    return new String(passwordCharacters);
  }

  static String incrementToNextPasswordObeyingRuleTwo(String password) {
    char[] chars = password.toCharArray();
    incrementToNextPasswordObeyingRuleTwo(chars);
    return new String(chars);
  }

  private static void incrementToNextPasswordObeyingRuleTwo(char[] passwordCharacters) {
    int length = passwordCharacters.length;

    for (int index = 0; index < length; index++) {
      char character = passwordCharacters[index];
      if (isNotAllowedCharacter(character)) {
        passwordCharacters[index] = (char) (character + 1);
        for (int index2 = index + 1; index2 < length; index2++) {
          passwordCharacters[index2] = 'a';
        }
        break;
      }
    }
  }

  static String increment(String password) {
    char[] chars = password.toCharArray();
    increment(chars);
    return new String(chars);
  }

  private static void increment(char[] passwordCharacters) {
    int length = passwordCharacters.length;

    for (int index = length - 1; index >= 0; index--) {
      char character = passwordCharacters[index];
      if (character < 'z') {

        // Applying rule two here saves us from checking all combinations following one of these
        // characters. Speeds up the process by factor 1.3.
        do {
          character++;
        } while (isNotAllowedCharacter(character));
        passwordCharacters[index] = character;

        break;
      } else {
        passwordCharacters[index] = 'a';
      }
    }
  }
}
