package eu.happycoders.adventofcode2015.day11;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Password security checker.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
@SuppressWarnings("PMD.AvoidLiteralsInIfCondition") // The literals' meaning is always clear
class PasswordSecurityChecker {

  static boolean isSecure(String password) {
    return isSecure(password.toCharArray());
  }

  static boolean isSecure(char[] passwordCharacters) {
    IsSecureContext context = new IsSecureContext();

    int length = passwordCharacters.length;
    for (int i = 0; i < length; i++) {
      context.setCharacter(passwordCharacters[i]);
      if (isNotAllowedCharacter(context.character)) {
        return false;
      }

      if (i > 0) {
        context.checkIfStraight();
        context.checkIfTwoPairsOfLetters();
      }
    }

    return context.straightFound && context.twoPairsOfLettersFound;
  }

  private static class IsSecureContext {

    private char character;
    private char lastCharacter;

    private int straightLength = 1;
    private boolean straightFound;

    private char firstDoublePairCharacter = ' ';
    private boolean twoPairsOfLettersFound;

    private void setCharacter(char character) {
      this.lastCharacter = this.character;
      this.character = character;
    }

    private void checkIfStraight() {
      if (straightFound) {
        return;
      }

      if (character == lastCharacter + 1) {
        straightLength++;
        if (straightLength == 3) {
          straightFound = true;
        }
      } else {
        straightLength = 1;
      }
    }

    private void checkIfTwoPairsOfLetters() {
      if (twoPairsOfLettersFound) {
        return;
      }

      if (character == lastCharacter) {
        if (firstDoublePairCharacter == ' ') {
          firstDoublePairCharacter = character;
        } else if (firstDoublePairCharacter != character) {
          twoPairsOfLettersFound = true;
        }
      }
    }
  }

  static boolean isNotAllowedCharacter(char character) {
    return character == 'i' || character == 'o' || character == 'l';
  }
}
