package eu.happycoders.adventofcode2015.day12;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class JsonAnalyzerTest {

  private static Stream<Arguments> jsonWithSumOfAllNumbers() {
    return Stream.of(
        Arguments.of("[1,2,3]", 6),
        Arguments.of("{\"a\":2,\"b\":4}", 6),
        Arguments.of("[[[3]]]", 3),
        Arguments.of("{\"a\":{\"b\":4},\"c\":-1}", 3),
        Arguments.of("{\"a\":[-1,1]}", 0),
        Arguments.of("[-1,{\"a\":1}]", 0),
        Arguments.of("[]", 0),
        Arguments.of("{}", 0));
  }

  @ParameterizedTest
  @MethodSource("jsonWithSumOfAllNumbers")
  void givenAJsonString_getSumOfAllNumbers_returnsTheExpectedSum(String json, int expectedSum) {
    int sum = JsonAnalyzer.getSumOfAllNumbers(json);

    assertThat(sum).isEqualTo(expectedSum);
  }

  private static Stream<Arguments> jsonWithSumOfAllNonRedNumbers() {
    return Stream.of(
        Arguments.of("[1,2,3]", 6),
        Arguments.of("{\"a\":2,\"b\":4}", 6),
        Arguments.of("[[[3]]]", 3),
        Arguments.of("{\"a\":{\"b\":4},\"c\":-1}", 3),
        Arguments.of("{\"a\":[-1,1]}", 0),
        Arguments.of("[-1,{\"a\":1}]", 0),
        Arguments.of("[]", 0),
        Arguments.of("{}", 0),
        Arguments.of("[1,{\"c\":\"red\",\"b\":2},3]", 4),
        Arguments.of("{\"d\":\"red\",\"e\":[1,2,3,4],\"f\":5}", 0),
        Arguments.of("[1,\"red\",5]", 6));
  }

  @ParameterizedTest
  @MethodSource("jsonWithSumOfAllNonRedNumbers")
  void givenAJsonString_getSumOfAllNonRedNumbers_returnsTheExpectedSum(
      String json, int expectedSum) {
    int sum = JsonAnalyzer.getSumOfAllNonRedNumbers(json);

    assertThat(sum).isEqualTo(expectedSum);
  }
}
