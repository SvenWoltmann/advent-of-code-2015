package eu.happycoders.adventofcode2015.day6;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Day6SolverTest {

  @Test
  void givenTestInput_solvePart1_returns998996() {
    String input = TestInputs.TEST_INPUT;

    int litLights = Day6Solver.solvePart1(input);

    assertThat(litLights).isEqualTo(998_996);
  }
}
