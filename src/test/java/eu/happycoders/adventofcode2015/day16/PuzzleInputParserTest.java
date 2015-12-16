package eu.happycoders.adventofcode2015.day16;

import static eu.happycoders.adventofcode2015.day16.TestInputs.SUE1;
import static eu.happycoders.adventofcode2015.day16.TestInputs.SUE2;
import static eu.happycoders.adventofcode2015.day16.TestInputs.SUE3;
import static eu.happycoders.adventofcode2015.day16.TestInputs.SUE4;
import static eu.happycoders.adventofcode2015.day16.TestInputs.SUE5;
import static eu.happycoders.adventofcode2015.day16.TestInputs.SUE6;
import static eu.happycoders.adventofcode2015.day16.TestInputs.TEST_INPUT;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class PuzzleInputParserTest {

  @Test
  void givenTestInput_parse_returnsTestSues() {
    String input = TEST_INPUT;

    List<Sue> sues = PuzzleInputParser.parse(input);

    assertThat(sues).containsExactly(SUE1, SUE2, SUE3, SUE4, SUE5, SUE6);
  }
}
