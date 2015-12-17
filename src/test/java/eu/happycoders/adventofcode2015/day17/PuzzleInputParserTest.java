package eu.happycoders.adventofcode2015.day17;

import static eu.happycoders.adventofcode2015.day17.TestInputs.TEST_CONTAINER_SIZES;
import static eu.happycoders.adventofcode2015.day17.TestInputs.TEST_INPUT;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class PuzzleInputParserTest {

  @Test
  void givenTestInput_parse_returnsTestSues() {
    String input = TEST_INPUT;

    List<Integer> containerSizes = PuzzleInputParser.parse(input);

    assertThat(containerSizes).isEqualTo(TEST_CONTAINER_SIZES);
  }
}
