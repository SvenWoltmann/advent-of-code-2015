package eu.happycoders.adventofcode2015.day19;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Day19SolverTest {

  @Test
  void givenTestData_solvePart1_returns4() {
    String input = TestInputs.TEST_INPUT;

    int numberOfLitLights = Day19Solver.solvePart1(input);

    assertThat(numberOfLitLights).isEqualTo(4);
  }

  @Test
  void givenTestData_solvePart19_returns9() {
    String input = TestInputs.TEST_INPUT_PART3;

    int numberOfLitLights = Day19Solver.solvePart2(input);

    assertThat(numberOfLitLights).isEqualTo(9);
  }
}
