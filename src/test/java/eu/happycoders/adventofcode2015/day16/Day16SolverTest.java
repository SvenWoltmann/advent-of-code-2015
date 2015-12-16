package eu.happycoders.adventofcode2015.day16;

import static eu.happycoders.adventofcode2015.day16.TestInputs.TEST_INPUT;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Day16SolverTest {

  @Test
  void givenTestData_solvePart1_returns5() {
    String input = TEST_INPUT;

    int sueNumber = Day16Solver.solvePart1(input);

    assertThat(sueNumber).isEqualTo(5);
  }

  @Test
  void givenTestData_solvePart2_returns6() {
    String input = TEST_INPUT;

    int sueNumber = Day16Solver.solvePart2(input);

    assertThat(sueNumber).isEqualTo(6);
  }
}
