package eu.happycoders.adventofcode2015.day23;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Day23SolverTest {

  @Test
  void givenTestInput_solvePart1_returns0() {
    String input = TestInputs.TEST_INPUT;

    int registerBValue = Day23Solver.solvePart1(input);

    assertThat(registerBValue).isZero();
  }

  @Test
  void givenExtendedTestInput_solvePart1_returns1() {
    String input = TestInputs.TEST_INPUT_EXTENDED;

    int registerBValue = Day23Solver.solvePart1(input);

    assertThat(registerBValue).isEqualTo(1);
  }

  @Test
  void givenExtendedTestInput_solvePart2_returns0() {
    String input = TestInputs.TEST_INPUT_EXTENDED;

    int registerBValue = Day23Solver.solvePart2(input);

    assertThat(registerBValue).isZero();
  }
}
