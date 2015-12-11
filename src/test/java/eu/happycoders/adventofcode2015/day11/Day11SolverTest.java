package eu.happycoders.adventofcode2015.day11;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Day11SolverTest {

  @Test
  void givenAPassword_solvePart1_returnsTheNextPassword() {
    String password = "abcdefgh";

    String nextPassword = Day11Solver.solvePart1(password);

    assertThat(nextPassword).isEqualTo("abcdffaa");
  }

  @Test
  void givenAPassword_solvePart2_returnsTheNextButOnePassword() {
    String password = "abcdefgh";

    String nextButOnePassword = Day11Solver.solvePart2(password);

    assertThat(nextButOnePassword).isEqualTo("abcdffbb");
  }
}
