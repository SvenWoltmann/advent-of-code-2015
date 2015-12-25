package eu.happycoders.adventofcode2015.day25;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Day25SolverTest {

  private static Stream<Arguments> rowAndColsAndExpectedCodes() {
    return Stream.of(
        Arguments.of(1, 1, 20151125),
        Arguments.of(2, 1, 31916031),
        Arguments.of(1, 2, 18749137),
        Arguments.of(3, 1, 16080970),
        Arguments.of(2, 2, 21629792),
        Arguments.of(1, 3, 17289845),
        Arguments.of(4, 1, 24592653));
  }

  @ParameterizedTest
  @MethodSource("rowAndColsAndExpectedCodes")
  void givenRowsAndCols_solve_returnsTheCorrespondingCode(int row, int column, int expectedCode) {
    int code = Day25Solver.solve(row, column);

    assertThat(code).isEqualTo(expectedCode);
  }
}
