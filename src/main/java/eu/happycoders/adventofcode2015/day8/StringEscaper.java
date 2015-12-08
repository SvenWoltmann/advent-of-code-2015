package eu.happycoders.adventofcode2015.day8;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>The String esccaper/unescaper.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class StringEscaper {

  static String unquoteAndUnescape(String escapedAndQuotedString) {
    if (escapedAndQuotedString.length() < 2
        || escapedAndQuotedString.charAt(0) != '"'
        || escapedAndQuotedString.charAt(escapedAndQuotedString.length() - 1) != '"') {
      throw new IllegalArgumentException("Not quoted correctly: " + escapedAndQuotedString);
    }

    return escapedAndQuotedString
        .substring(1, escapedAndQuotedString.length() - 1)
        .replace("\\\"", "\"")
        .replace("\\\\", "\\")
        .replaceAll("\\\\x[\\da-f]{2}", "*");
  }

  static String escapeAndQuote(String string) {
    // We have to escape character by character. If we use String.replace() or String.replaceAll()
    // multiple times, we will escpae certain characters multiple times.
    StringBuilder result = new StringBuilder();
    result.append('"');

    for (int i = 0; i < string.length(); i++) {
      char character = string.charAt(i);
      if (character == '"' || character == '\\') {
        result.append('\\').append(character);
      } else {
        result.append(character);
      }
    }

    result.append('"');
    return result.toString();
  }
}
