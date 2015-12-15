package eu.happycoders.adventofcode2015.day15;

import java.util.List;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Chooser for the best ingredients for a cookie.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class IngredientChooser {

  private static final int NUMBER_OF_TEASPOONS = 100;

  private final List<Ingredient> ingredients;

  private final int numberOfIngredient;
  private final int[] teaspoonsPerIngredient;
  private int highestCookieScore;

  IngredientChooser(List<Ingredient> ingredients) {
    this.ingredients = ingredients;
    this.numberOfIngredient = ingredients.size();
    this.teaspoonsPerIngredient = new int[ingredients.size()];
  }

  int calculateHighestCookieScore(Integer requestedCalories) {
    highestCookieScore = 0;
    tryAllPossibleAmountsRecursively(0, NUMBER_OF_TEASPOONS, requestedCalories);
    return highestCookieScore;
  }

  private void tryAllPossibleAmountsRecursively(
      int ingredientIndex, int remainingTeaspoons, Integer requestedCalories) {
    // Last ingredient?
    if (ingredientIndex == numberOfIngredient - 1) {
      this.teaspoonsPerIngredient[ingredientIndex] = remainingTeaspoons;
      int cookieScore = calculateCookieScore(requestedCalories);
      if (cookieScore > highestCookieScore) {
        highestCookieScore = cookieScore;
      }
      return;
    }

    for (int teaspoons = 0; teaspoons <= remainingTeaspoons; teaspoons++) {
      this.teaspoonsPerIngredient[ingredientIndex] = teaspoons;
      tryAllPossibleAmountsRecursively(
          ingredientIndex + 1, remainingTeaspoons - teaspoons, requestedCalories);
    }
  }

  private int calculateCookieScore(Integer requestedCalories) {
    int capacity = 0;
    int durability = 0;
    int flavor = 0;
    int texture = 0;
    int calories = 0;

    for (int i = 0; i < numberOfIngredient; i++) {
      Ingredient ingredient = ingredients.get(i);
      int teaspoons = teaspoonsPerIngredient[i];

      capacity += ingredient.capacity() * teaspoons;
      durability += ingredient.durability() * teaspoons;
      flavor += ingredient.flavor() * teaspoons;
      texture += ingredient.texture() * teaspoons;
      calories += ingredient.calories() * teaspoons;
    }

    if (requestedCalories != null && requestedCalories != calories) {
      return 0;
    }

    return Math.max(0, capacity)
        * Math.max(0, durability)
        * Math.max(0, flavor)
        * Math.max(0, texture);
  }
}
