package eu.happycoders.adventofcode2015.day24;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Day24SolverTest {

  @Test
  void givenTestInput_solvePart1_returns99() {
    String input = TestInputs.TEST_INPUT;

    long idealConfigurationQE = Day24Solver.solvePart1(input);

    assertThat(idealConfigurationQE).isEqualTo(99L);
  }

  @Test
  void givenTestInput_solvePart2_returns44() {
    String input = TestInputs.TEST_INPUT;

    long idealConfigurationQE = Day24Solver.solvePart2(input);

    assertThat(idealConfigurationQE).isEqualTo(44L);
  }
}
