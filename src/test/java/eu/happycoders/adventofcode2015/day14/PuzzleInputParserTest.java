package eu.happycoders.adventofcode2015.day14;

import static eu.happycoders.adventofcode2015.day14.TestInputs.TEST_INPUT;
import static eu.happycoders.adventofcode2015.day14.TestInputs.TEST_REINDEER;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class PuzzleInputParserTest {

  @Test
  void givenTestInput_parse_returnsTestReindeer() {
    String input = TEST_INPUT;

    List<Reindeer> reindeer = PuzzleInputParser.parse(input);

    assertThat(reindeer).isEqualTo(TEST_REINDEER);
  }
}
