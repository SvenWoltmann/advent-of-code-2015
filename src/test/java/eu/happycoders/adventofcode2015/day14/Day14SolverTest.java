package eu.happycoders.adventofcode2015.day14;

import static eu.happycoders.adventofcode2015.day14.TestInputs.TEST_INPUT;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Day14SolverTest {

  @Test
  void givenTestData_solvePart1_returns2660() {
    String input = TEST_INPUT;

    int farthestDistance = Day14Solver.solvePart1(input);

    assertThat(farthestDistance).isEqualTo(2660);
  }

  @Test
  void givenTestData_solvePart2_returns1564() {
    String input = TEST_INPUT;

    int mostPoints = Day14Solver.solvePart2(input);

    assertThat(mostPoints).isEqualTo(1564);
  }
}
