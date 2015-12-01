package eu.happycoders.adventofcode2015.day1;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Day1SolverTest {

  private static Stream<Arguments> inputsAndExpectedFloors() {
    return Stream.of(
        Arguments.of("(())", 0),
        Arguments.of("()()", 0),
        Arguments.of("(((", 3),
        Arguments.of("(()(()(", 3),
        Arguments.of("))(((((", 3),
        Arguments.of("())", -1),
        Arguments.of("))(", -1),
        Arguments.of(")))", -3),
        Arguments.of(")())())", -3));
  }

  @ParameterizedTest
  @MethodSource("inputsAndExpectedFloors")
  void givenTestInput_solvePart1_returnsTheExpectedFloor(String input, int expectedFloor) {
    int floor = Day1Solver.solvePart1(input);
    assertThat(floor).isEqualTo(expectedFloor);
  }

  @Test
  void givenDown_solvePart2_returns1() {
    int numberOfInstructions = Day1Solver.solvePart2(")");
    assertThat(numberOfInstructions).isEqualTo(1);
  }

  @Test
  void givenUpDownUpDownDown_solvePart2_returns5() {
    int numberOfInstructions = Day1Solver.solvePart2("()())");
    assertThat(numberOfInstructions).isEqualTo(5);
  }
}
