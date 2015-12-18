package eu.happycoders.adventofcode2015.day18;

import static eu.happycoders.adventofcode2015.day18.TestInputs.TEST_LIT_LIGHTS;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class PuzzleInputParserTest {

  @Test
  void givenTestInput_parse_returnsTestSues() {
    String input = TestInputs.TEST_INPUT;

    boolean[][] litLights = PuzzleInputParser.parse(input);

    assertThat(litLights).isDeepEqualTo(TEST_LIT_LIGHTS);
  }
}
