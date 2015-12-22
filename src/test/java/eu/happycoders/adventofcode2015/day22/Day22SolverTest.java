package eu.happycoders.adventofcode2015.day22;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Day22SolverTest {

  @Test
  void givenTestInput_solvePart1_returns491() {
    String input = TestInputs.TEST_INPUT_MORE_HITPOINTS;

    int cost = Day22Solver.solvePart1(input);

    assertThat(cost).isEqualTo(491);
  }

  @Test
  void givenTestInput_solvePart2_returns734() {
    String input = TestInputs.TEST_INPUT_MORE_HITPOINTS;

    int cost = Day22Solver.solvePart2(input);

    assertThat(cost).isEqualTo(734);
  }
}
