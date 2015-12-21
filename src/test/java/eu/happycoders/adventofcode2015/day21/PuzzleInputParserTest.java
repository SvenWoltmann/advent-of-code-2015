package eu.happycoders.adventofcode2015.day21;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class PuzzleInputParserTest {

  @Test
  void givenTestInput_parse_returnsTestBossStats() {
    String input = TestInputs.TEST_INPUT;

    PlayerStats bossStats = PuzzleInputParser.parse(input);

    assertThat(bossStats).isEqualTo(TestInputs.TEST_BOSS_STATS);
  }
}
