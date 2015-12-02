package eu.happycoders.adventofcode2015.day2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Day2SolverTest {

  @Test
  void givenSomeTestInput_solvePart1_returns101() {
    String input = "2x3x4\n1x1x10";

    int totalRequiredWrappingPaper = Day2Solver.solvePart1(input);

    assertThat(totalRequiredWrappingPaper).isEqualTo(101);
  }

  @Test
  void givenSomeTestInput_solvePart2_returns48() {
    String input = "2x3x4\n1x1x10";

    int totalRequiredWrappingPaper = Day2Solver.solvePart2(input);

    assertThat(totalRequiredWrappingPaper).isEqualTo(48);
  }
}
