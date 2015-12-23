package eu.happycoders.adventofcode2015.day23;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class PuzzleInputParserTest {

  @Test
  void givenTestInput_parse_returnsTestInstructions() {
    String input = TestInputs.TEST_INPUT;

    List<Instruction> instructions = PuzzleInputParser.parse(input);

    assertThat(instructions).isEqualTo(TestInputs.TEST_INSTRUCTIONS);
  }

  @Test
  void givenTestInputExtended_parse_returnsTestInstructionsExtended() {
    String input = TestInputs.TEST_INPUT_EXTENDED;

    List<Instruction> instructions = PuzzleInputParser.parse(input);

    assertThat(instructions).isEqualTo(TestInputs.TEST_INSTRUCTIONS_EXTENDED);
  }
}
