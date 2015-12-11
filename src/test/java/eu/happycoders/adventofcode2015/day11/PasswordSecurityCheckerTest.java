package eu.happycoders.adventofcode2015.day11;

import static eu.happycoders.adventofcode2015.day11.PasswordSecurityChecker.isSecure;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PasswordSecurityCheckerTest {

  @ParameterizedTest
  @ValueSource(strings = {"abcdffaa", "ghjaabcc"})
  void givenASecurePassword_isSecure_returnsTrue(String password) {
    boolean secure = isSecure(password);

    assertThat(secure).isTrue();
  }

  @ParameterizedTest
  @ValueSource(strings = {"hijklmmn", "abbceffg", "abbcegjk", "abbcefgh"})
  void givenAnInsecurePassword_isSecure_returnsFalse(String password) {
    boolean secure = isSecure(password);

    assertThat(secure).isFalse();
  }
}
