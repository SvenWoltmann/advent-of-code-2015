package eu.happycoders.adventofcode2015.day4;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Day4SolverTest {

  private static Stream<Arguments> part1testData() {
    return Stream.of(
        Arguments.of("abcdef", 609043), //
        Arguments.of("pqrstuv", 1048970));
  }

  @ParameterizedTest
  @MethodSource("part1testData")
  void givenTestInput_solvePart1_returnsTheExpectedResult(String input, int expectedResult) {
    int result = Day4Solver.solvePart1(input);

    assertThat(result).isEqualTo(expectedResult);
  }
}
