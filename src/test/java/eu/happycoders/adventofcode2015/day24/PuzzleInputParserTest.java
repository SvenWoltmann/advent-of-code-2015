package eu.happycoders.adventofcode2015.day24;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class PuzzleInputParserTest {

  @Test
  void givenSomeTestInput_parse_returnsTheParsedNumbers() {
    String input = TestInputs.TEST_INPUT;

    List<Integer> weights = PuzzleInputParser.parse(input);

    assertThat(weights).isEqualTo(TestInputs.TEST_WEIGHTS);
  }
}
