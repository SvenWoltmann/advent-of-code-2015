package eu.happycoders.adventofcode2015.day3;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Day3SolverTest {

  private static Stream<Arguments> part1testData() {
    return Stream.of(
        Arguments.of(">", 2), //
        Arguments.of("^>v<", 4),
        Arguments.of("^v^v^v^v^v", 2));
  }

  @ParameterizedTest
  @MethodSource("part1testData")
  void givenTestInput_solvePart1_returnsTheExpectedResult(String input, int expectedResult) {
    int result = Day3Solver.solvePart1(input);

    assertThat(result).isEqualTo(expectedResult);
  }

  private static Stream<Arguments> part2testData() {
    return Stream.of(
        Arguments.of("^v", 3), //
        Arguments.of("^>v<", 3),
        Arguments.of("^v^v^v^v^v", 11));
  }

  @ParameterizedTest
  @MethodSource("part2testData")
  void givenTestInput_solvePart2_returnsTheExpectedResult(String input, int expectedResult) {
    int result = Day3Solver.solvePart2(input);

    assertThat(result).isEqualTo(expectedResult);
  }
}
