package eu.happycoders.adventofcode2015.day11;

import static eu.happycoders.adventofcode2015.day11.PasswordGenerator.findNextSecurePassword;
import static eu.happycoders.adventofcode2015.day11.PasswordGenerator.increment;
import static eu.happycoders.adventofcode2015.day11.PasswordGenerator.incrementToNextPasswordObeyingRuleTwo;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PasswordGeneratorTest {

  private static Stream<Arguments> passwordsWithNextSecurePassword() {
    return Stream.of(Arguments.of("abcdefgh", "abcdffaa"), Arguments.of("ghijklmn", "ghjaabcc"));
  }

  @ParameterizedTest
  @MethodSource("passwordsWithNextSecurePassword")
  void givenAPassword_findNextSecurePassword_returnsTheExpectedNextSecurePassword(
      String password, String expectedNextSecurePassword) {
    String nextSecurePasswordPassword = findNextSecurePassword(password);

    assertThat(nextSecurePasswordPassword).isEqualTo(expectedNextSecurePassword);
  }

  private static Stream<Arguments> passwordsWithTheNextPasswordObeyingRuleTwo() {
    return Stream.of(
        Arguments.of("abcdefgh", "abcdefgh"),
        Arguments.of("aiaaaaaa", "ajaaaaaa"),
        Arguments.of("aiabcdef", "ajaaaaaa"),
        Arguments.of("bcdefghi", "bcdefghj"));
  }

  @ParameterizedTest
  @MethodSource("passwordsWithTheNextPasswordObeyingRuleTwo")
  void givenAPassword_incrementToNextPasswordObeyingRuleTwo_returnsTheExpectedIncrementedPassword(
      String password, String expectedIncrementedPassword) {
    String incrementedPassword = incrementToNextPasswordObeyingRuleTwo(password);

    assertThat(incrementedPassword).isEqualTo(expectedIncrementedPassword);
  }

  private static Stream<Arguments> passwordsWithTheirIncrements() {
    return Stream.of(
        Arguments.of("aaaaaaaa", "aaaaaaab"),
        Arguments.of("aaaaaaaz", "aaaaaaba"),
        Arguments.of("yzzzzzzz", "zaaaaaaa"),
        Arguments.of("zzzzzzzz", "aaaaaaaa"));
  }

  @ParameterizedTest
  @MethodSource("passwordsWithTheirIncrements")
  void givenAPassword_increment_returnsTheExpectedIncrementedPassword(
      String password, String expectedIncrementedPassword) {
    String incrementedPassword = increment(password);

    assertThat(incrementedPassword).isEqualTo(expectedIncrementedPassword);
  }
}
