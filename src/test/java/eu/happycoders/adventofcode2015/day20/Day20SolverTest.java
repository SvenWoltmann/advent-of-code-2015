package eu.happycoders.adventofcode2015.day20;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Day20SolverTest {

  @Test
  void given150Presents_solvePart1_returns8() {
    int presents = 150;

    int lowestHouseNumber = Day20Solver.solvePart1(presents);

    assertThat(lowestHouseNumber).isEqualTo(8);
  }

  @Test
  void given150Presents_solvePart2_returns8() {
    int presents = 150;

    int lowestHouseNumber = Day20Solver.solvePart2(presents);

    assertThat(lowestHouseNumber).isEqualTo(8);
  }

  @Test
  void given1500Presents_solvePart1_returns4320() {
    int presents = 150_000;

    int lowestHouseNumber = Day20Solver.solvePart1(presents);

    assertThat(lowestHouseNumber).isEqualTo(4320);
  }

  @Test
  void given1500Presents_solvePart2_returns4200() {
    int presents = 150_000;

    int lowestHouseNumber = Day20Solver.solvePart2(presents);

    assertThat(lowestHouseNumber).isEqualTo(4200);
  }
}
