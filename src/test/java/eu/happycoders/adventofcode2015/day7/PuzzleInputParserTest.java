package eu.happycoders.adventofcode2015.day7;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class PuzzleInputParserTest {

  @Test
  void givenTestInput_parse_returnsParsedInstructions() {
    String input = TestInputs.TEST_INPUT;

    List<Instruction> instructions = PuzzleInputParser.parse(input);

    assertThat(instructions).isEqualTo(TestInputs.TEST_INSTRUCTIONS);
  }
}
