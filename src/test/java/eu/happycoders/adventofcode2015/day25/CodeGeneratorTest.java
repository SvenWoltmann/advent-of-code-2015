package eu.happycoders.adventofcode2015.day25;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CodeGeneratorTest {

  private static Stream<Arguments> iterationsAndExpectedCodes() {
    return Stream.of(
        Arguments.of(0, 20151125),
        Arguments.of(1, 31916031),
        Arguments.of(2, 18749137),
        Arguments.of(3, 16080970),
        Arguments.of(4, 21629792),
        Arguments.of(5, 17289845),
        Arguments.of(10, 77061),
        Arguments.of(15, 33071741));
  }

  @ParameterizedTest
  @MethodSource("iterationsAndExpectedCodes")
  void givenASpecificNumberOfIterations_getCode_returnsTheExpectedCode(
      int iterations, int expectedCode) {
    int code = CodeGenerator.getCode(iterations);

    assertThat(code).isEqualTo(expectedCode);
  }
}
