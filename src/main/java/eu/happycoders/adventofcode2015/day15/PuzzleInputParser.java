package eu.happycoders.adventofcode2015.day15;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Parses the input text into a list of {@link Ingredient}s.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class PuzzleInputParser {

  private static final Pattern PATTERN =
      Pattern.compile(
          "([A-Za-z]+): capacity (-?\\d+), durability (-?\\d+), "
              + "flavor (-?\\d+), texture (-?\\d+), calories (-?\\d+)");

  static List<Ingredient> parse(String input) {
    return Arrays.stream(input.split("\\r?\\n"))
        .map(PuzzleInputParser::parseIngredient)
        .collect(Collectors.toList());
  }

  private static Ingredient parseIngredient(String input) {
    Matcher matcher = PATTERN.matcher(input);
    if (!matcher.matches()) {
      throw new IllegalArgumentException(input);
    }

    String name = matcher.group(1);
    int capacity = Integer.parseInt(matcher.group(2));
    int durability = Integer.parseInt(matcher.group(3));
    int flavor = Integer.parseInt(matcher.group(4));
    int texture = Integer.parseInt(matcher.group(5));
    int calories = Integer.parseInt(matcher.group(6));

    return new Ingredient(name, capacity, durability, flavor, texture, calories);
  }
}
