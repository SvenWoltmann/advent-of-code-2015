package eu.happycoders.adventofcode2015.day9;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class PuzzleInputParserTest {

  @Test
  void givenTestInput_parse_returnsParsedDistances() {
    String input = TestInputs.TEST_INPUT;

    List<Path> paths = PuzzleInputParser.parse(input);

    assertThat(paths).isEqualTo(TestInputs.TEST_PATHS);
  }
}
