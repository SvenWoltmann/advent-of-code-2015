package eu.happycoders.adventofcode2015.day18;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Day18SolverTest {

  @Test
  void givenTestData_solvePart1_returns4() {
    String input = TestInputs.TEST_INPUT;

    int numberOfLitLights = Day18Solver.solvePart1(input);

    assertThat(numberOfLitLights).isEqualTo(4);
  }

  @Test
  void givenTestData_solvePart2_returns7() {
    String input = TestInputs.TEST_INPUT;

    int numberOfLitLights = Day18Solver.solvePart2(input);

    assertThat(numberOfLitLights).isEqualTo(7);
  }
}
