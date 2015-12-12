package eu.happycoders.adventofcode2015.day12;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Day12SolverTest {

  private static final String TEST_INPUT = "[1,{\"d\":\"red\",\"e\":[1,2,3,4],\"f\":5},2]";

  @Test
  void givenTestInput_solvePart1_returns18() {
    int sumOfAllNumbers = Day12Solver.solvePart1(TEST_INPUT);

    assertThat(sumOfAllNumbers).isEqualTo(18);
  }

  @Test
  void givenTestInput_solvePart2_returns3() {
    int sumOfAllNonRedNumbers = Day12Solver.solvePart2(TEST_INPUT);

    assertThat(sumOfAllNonRedNumbers).isEqualTo(3);
  }
}
