package eu.happycoders.adventofcode2015.day15;

import static eu.happycoders.adventofcode2015.day15.TestInputs.TEST_INGREDIENTS;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class IngredientChooserTest {

  @Test
  void givenAnIngredientChooserWithTestIngredients_calculateHighestCookieScore_returns62842880() {
    IngredientChooser ingredientChooser = new IngredientChooser(TEST_INGREDIENTS);

    int highestCookieScore = ingredientChooser.calculateHighestCookieScore(null);

    assertThat(highestCookieScore).isEqualTo(62_842_880);
  }

  @Test
  void
      givenAnIngredientChooserWithTestIngredients_calculateHighestCookieScoreFor500Calories_returns57600000() {
    IngredientChooser ingredientChooser = new IngredientChooser(TEST_INGREDIENTS);

    int highestCookieScore = ingredientChooser.calculateHighestCookieScore(500);

    assertThat(highestCookieScore).isEqualTo(57_600_000);
  }
}
