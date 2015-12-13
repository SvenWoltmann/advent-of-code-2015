package eu.happycoders.adventofcode2015.day13;

import static eu.happycoders.adventofcode2015.day13.TestInputs.TEST_INPUT;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Day13SolverTest {

  @Test
  void givenTestData_solvePart1_returns330() {
    String input = TEST_INPUT;

    int totalChangeInHappiness = Day13Solver.solvePart1(input);

    assertThat(totalChangeInHappiness).isEqualTo(330);
  }

  @Test
  void givenTestData_solvePart2_returns286() {
    String input = TEST_INPUT;

    int totalChangeInHappiness = Day13Solver.solvePart2(input);

    assertThat(totalChangeInHappiness).isEqualTo(286);
  }
}
