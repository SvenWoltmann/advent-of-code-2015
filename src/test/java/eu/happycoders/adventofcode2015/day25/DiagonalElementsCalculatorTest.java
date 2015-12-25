package eu.happycoders.adventofcode2015.day25;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class DiagonalElementsCalculatorTest {

  private static Stream<Arguments> rowsAndColumnsAndExpectedElementIndicees() {
    return Stream.of(
        Arguments.of(0, 0, 0),
        Arguments.of(1, 0, 1),
        Arguments.of(0, 1, 2),
        Arguments.of(2, 0, 3),
        Arguments.of(1, 1, 4),
        Arguments.of(0, 2, 5),
        Arguments.of(3, 0, 6),
        Arguments.of(2, 1, 7),
        Arguments.of(1, 2, 8),
        Arguments.of(0, 3, 9),
        Arguments.of(4, 0, 10),
        Arguments.of(0, 4, 14));
  }

  @ParameterizedTest
  @MethodSource("rowsAndColumnsAndExpectedElementIndicees")
  void givenASpecificRowAndColumn_calculateElementIndex_returnsTheExpectedElementIndex(
      int row, int column, int expectedElementIndex) {
    int elementIndex = DiagonalElementsCalculator.calculateElementIndex(row, column);

    assertThat(elementIndex).isEqualTo(expectedElementIndex);
  }
}
