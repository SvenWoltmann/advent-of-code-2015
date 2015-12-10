package eu.happycoders.adventofcode2015.day10;

class LookAndSay {

  static String lookAndSay(String input, int times) {
    String result = input;
    for (int i = 0; i < times; i++) {
      result = lookAndSay(result);
    }
    return result;
  }

  static String lookAndSay(String input) {
    StringBuilder result = new StringBuilder(input.length() * 14 / 10);

    char lastDigit = ' ';
    int lastDigitPos = 0;

    for (int i = 0; i < input.length(); i++) {
      char digit = input.charAt(i);
      if (i == 0) {
        lastDigit = digit;
      } else {
        if (digit != lastDigit) {
          int numberOfLastDigit = i - lastDigitPos;
          result.append(numberOfLastDigit).append(lastDigit);
          lastDigitPos = i;
          lastDigit = digit;
        }
      }
    }

    int numberOfLastDigit = input.length() - lastDigitPos;
    result.append(numberOfLastDigit).append(lastDigit);

    return result.toString();
  }
}
