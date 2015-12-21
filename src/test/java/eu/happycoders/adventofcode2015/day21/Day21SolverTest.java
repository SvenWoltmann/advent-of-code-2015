package eu.happycoders.adventofcode2015.day21;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Day21SolverTest {

  @Test
  void givenTestInput_solvePart1_returns71() {
    String input = TestInputs.TEST_INPUT_MORE_HITPOINTS;

    int cost = Day21Solver.solvePart1(input);

    assertThat(cost).isEqualTo(71);
  }

  @Test
  void givenTestInput_solvePart2_returns133() {
    String input = TestInputs.TEST_INPUT_MORE_HITPOINTS;

    int cost = Day21Solver.solvePart2(input);

    assertThat(cost).isEqualTo(133);
  }
}
