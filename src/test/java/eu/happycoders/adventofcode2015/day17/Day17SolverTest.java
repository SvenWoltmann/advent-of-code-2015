package eu.happycoders.adventofcode2015.day17;

import static eu.happycoders.adventofcode2015.day17.TestInputs.TEST_INPUT;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Day17SolverTest {

  @Test
  void givenTestData_solvePart1_returns4() {
    String input = TEST_INPUT;

    int numberOfCombinations = Day17Solver.solvePart1(input, 25);

    assertThat(numberOfCombinations).isEqualTo(4);
  }

  @Test
  void givenTestData_solvePart2_returns3() {
    String input = TEST_INPUT;

    int numberOfCombinationsWithFewestNumberOfContainers = Day17Solver.solvePart2(input, 25);

    assertThat(numberOfCombinationsWithFewestNumberOfContainers).isEqualTo(3);
  }
}
