package eu.happycoders.adventofcode2015.day7;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Day7SolverTest {

  static final String TEST_INPUT =
      "f AND h -> a\n"
          + "123 -> b\n"
          + "2 -> c\n"
          + "NOT b -> d\n"
          + "b LSHIFT c -> e\n"
          + "d -> f\n"
          + "e RSHIFT 2 -> g\n"
          + "g OR i -> h\n"
          + "b LSHIFT 5 -> i";

  @Test
  void givenTestInput_solvePart1_returns3840() {
    String input = TEST_INPUT;

    int signalA = Day7Solver.solvePart1(input);

    assertThat(signalA).isEqualTo(3840);
  }

  @Test
  void givenTestInput_solvePart2_returns57344() {
    String input = TEST_INPUT;

    int signalA = Day7Solver.solvePart2(input);

    assertThat(signalA).isEqualTo(57344);
  }
}
