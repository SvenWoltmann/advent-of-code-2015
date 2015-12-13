package eu.happycoders.adventofcode2015.day13;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class PuzzleInputParserTest {

  @Test
  void givenTestInput_parse_returnsPotentialHappinessList() {
    String input = TestInputs.TEST_INPUT;

    List<PotentialHappiness> potentialHappinesses = PuzzleInputParser.parse(input);

    assertThat(potentialHappinesses).isEqualTo(TestInputs.TEST_POTENTIAL_HAPPINESSES);
  }
}
