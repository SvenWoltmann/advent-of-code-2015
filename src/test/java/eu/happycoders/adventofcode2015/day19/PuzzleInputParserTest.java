package eu.happycoders.adventofcode2015.day19;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class PuzzleInputParserTest {

  @Test
  void givenTestInput_parse_returnsTestPuzzleInput() {
    String input = TestInputs.TEST_INPUT;

    PuzzleInput puzzleInput = PuzzleInputParser.parse(input);

    assertThat(puzzleInput).isEqualTo(TestInputs.TEST_PUZZLE_INPUT);
  }
}
