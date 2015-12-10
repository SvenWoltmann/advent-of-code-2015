package eu.happycoders.adventofcode2015.day10;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LookAndSayTest {

  private static Stream<Arguments> lookAndSayTestInput() {
    return Stream.of(
        Arguments.of("1", "11"),
        Arguments.of("11", "21"),
        Arguments.of("21", "1211"),
        Arguments.of("1211", "111221"),
        Arguments.of("111221", "312211"));
  }

  @ParameterizedTest
  @MethodSource("lookAndSayTestInput")
  void givenTheInput_lookAndSay_returnsTheExpectedOutput(String input, String expectedOutput) {
    String output = LookAndSay.lookAndSay(input);

    assertThat(output).isEqualTo(expectedOutput);
  }

  @Test
  void given1_lookAndSay5Times_returns312211() {
    String input = "1";

    String output = LookAndSay.lookAndSay(input, 5);

    assertThat(output).isEqualTo("312211");
  }
}
