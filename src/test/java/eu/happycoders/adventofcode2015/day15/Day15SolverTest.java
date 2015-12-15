package eu.happycoders.adventofcode2015.day15;

import static eu.happycoders.adventofcode2015.day15.TestInputs.TEST_INPUT;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Day15SolverTest {

  @Test
  void givenTestData_solvePart1_returns62842880() {
    String input = TEST_INPUT;

    int highestCookieScore = Day15Solver.solvePart1(input);

    assertThat(highestCookieScore).isEqualTo(62_842_880);
  }

  @Test
  void givenTestData_solvePart2_returns57600000() {
    String input = TEST_INPUT;

    int highestCookieScore = Day15Solver.solvePart2(input);

    assertThat(highestCookieScore).isEqualTo(57_600_000);
  }
}
