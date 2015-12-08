package eu.happycoders.adventofcode2015.day8;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Day8SolverTest {

  static final String TEST_INPUT =
      "\"\"\n" //
          + "\"abc\"\n"
          + "\"aaa\\\"aaa\"\n"
          + "\"\\x27\"";

  @Test
  void givenTestInput_solvePart1_returns12() {
    String input = TEST_INPUT;

    int diffSum = Day8Solver.solvePart1(input);

    assertThat(diffSum).isEqualTo(12);
  }

  @Test
  void givenTestInput_solvePart2_returns19() {
    String input = TEST_INPUT;

    int signalA = Day8Solver.solvePart2(input);

    assertThat(signalA).isEqualTo(19);
  }
}
