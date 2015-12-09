package eu.happycoders.adventofcode2015.day9;

import static eu.happycoders.adventofcode2015.day9.TestInputs.TEST_INPUT;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Day9SolverTest {

  @Test
  void givenTestInput_solvePart1_returns605() {
    String input = TEST_INPUT;

    int lengthOfShortestRoute = Day9Solver.solvePart1(input);

    assertThat(lengthOfShortestRoute).isEqualTo(605);
  }

  @Test
  void givenTestInput_solvePart2_returns982() {
    String input = TEST_INPUT;

    int lengthOfLongestRoute = Day9Solver.solvePart2(input);

    assertThat(lengthOfLongestRoute).isEqualTo(982);
  }
}
