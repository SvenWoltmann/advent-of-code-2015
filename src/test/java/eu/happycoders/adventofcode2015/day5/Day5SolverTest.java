package eu.happycoders.adventofcode2015.day5;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Day5SolverTest {

  @Test
  void givenTestInput_solvePart1_returns2() {
    String input =
        "ugknbfddgicrmopn\n"
            + "aaa\n"
            + "jchzalrnumimnmhp\n"
            + "haegwjzuvuyypxyu\n"
            + "dvszwmarrgswjxmb";

    int numberOfNiceStrings = Day5Solver.solvePart1(input);

    assertThat(numberOfNiceStrings).isEqualTo(2);
  }

  @Test
  void givenTestInput_solvePart2_returns2() {
    String input =
        "qjhvhtzxzqqjkmpb\n" //
            + "xxyxx\n"
            + "uurcxstgmygtbstg\n"
            + "ieodomkazucvgmuy";

    int numberOfNiceStrings = Day5Solver.solvePart2(input);

    assertThat(numberOfNiceStrings).isEqualTo(2);
  }
}
