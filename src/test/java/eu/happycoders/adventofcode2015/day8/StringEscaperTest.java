package eu.happycoders.adventofcode2015.day8;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class StringEscaperTest {

  private static Stream<Arguments> testInputWithUnquotedAndUnescapedLengths() {
    return Stream.of(
        Arguments.of("\"\"", 0),
        Arguments.of("\"abc\"", 3),
        Arguments.of("\"aaa\\\"aaa\"", 7),
        Arguments.of("\"\\x27\"", 1),
        Arguments.of("\"\\\"w\\x67jwaq\\x7ernmyvs\\\\rmdsuwydsd\\\"th\"", 28));
  }

  @ParameterizedTest
  @MethodSource("testInputWithUnquotedAndUnescapedLengths")
  void givenAString_unquoteAndUnescape_returnsAStringOfTheExpectedLength(
      String string, int expectedLength) {
    int length = StringEscaper.unquoteAndUnescape(string).length();

    assertThat(length).isEqualTo(expectedLength);
  }

  @ParameterizedTest
  @ValueSource(strings = {"", "\"", "\"foo", "foo\"", "foo"})
  void givenANotCorrectlyQuotedString_unquoteAndUnescape_throwsException(String string) {
    assertThatIllegalArgumentException()
        .isThrownBy(() -> StringEscaper.unquoteAndUnescape(string))
        .withMessageStartingWith("Not quoted correctly");
  }

  private static Stream<Arguments> testInputWithEscapedAndQuotedLengths() {
    return Stream.of(
        Arguments.of("\"\"", 6),
        Arguments.of("\"abc\"", 9),
        Arguments.of("\"aaa\\\"aaa\"", 16),
        Arguments.of("\"\\x27\"", 11),
        Arguments.of("\"\\\"w\\x67jwaq\\x7ernmyvs\\\\rmdsuwydsd\\\"th\"", 51));
  }

  @ParameterizedTest
  @MethodSource("testInputWithEscapedAndQuotedLengths")
  void givenAString_escapeAndQuote_returnsAStringOfTheExpectedLength(
      String string, int expectedLength) {
    int length = StringEscaper.escapeAndQuote(string).length();

    assertThat(length).isEqualTo(expectedLength);
  }
}
