package eu.happycoders.adventofcode2015.day15;

import static eu.happycoders.adventofcode2015.day15.TestInputs.TEST_INGREDIENTS;
import static eu.happycoders.adventofcode2015.day15.TestInputs.TEST_INPUT;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class PuzzleInputParserTest {

  @Test
  void givenTestInput_parse_returnsTestIngredients() {
    String input = TEST_INPUT;

    List<Ingredient> reindeer = PuzzleInputParser.parse(input);

    assertThat(reindeer).isEqualTo(TEST_INGREDIENTS);
  }
}
