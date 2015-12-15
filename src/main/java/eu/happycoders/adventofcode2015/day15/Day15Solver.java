package eu.happycoders.adventofcode2015.day15;

import java.util.List;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Puzzle solver for day 15.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class Day15Solver {

  static int solvePart1(String input) {
    List<Ingredient> ingredients = PuzzleInputParser.parse(input);
    IngredientChooser ingredientChooser = new IngredientChooser(ingredients);
    return ingredientChooser.calculateHighestCookieScore(null);
  }

  static int solvePart2(String input) {
    List<Ingredient> ingredients = PuzzleInputParser.parse(input);
    IngredientChooser ingredientChooser = new IngredientChooser(ingredients);
    return ingredientChooser.calculateHighestCookieScore(500);
  }
}
