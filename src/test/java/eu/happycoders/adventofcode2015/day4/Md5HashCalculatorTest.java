package eu.happycoders.adventofcode2015.day4;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Md5HashCalculatorTest {

  private static Stream<Arguments> secretKeysAndNumbersWithMd5Hash() {
    return Stream.of(
        Arguments.of("abcdef", 609043, "000001dbbfa3a5c83a2d506429c7b00e"), //
        Arguments.of("pqrstuv", 1048970, "000006136ef2ff3b291c85725f17325c"));
  }

  @ParameterizedTest
  @MethodSource("secretKeysAndNumbersWithMd5Hash")
  void givenASecretKeyAndANumber_calculateMd5Hash_returnsTheCorrectHash(
      String secretKey, int number, String expectedHash) {
    byte[] hash = Md5HashCalculator.calculateMd5Hash(secretKey, number);

    String hashAsString = toHexString(hash);

    assertThat(hashAsString).isEqualTo(expectedHash);
  }

  public static String toHexString(byte[] bytes) {
    StringBuilder result = new StringBuilder();
    for (byte aByte : bytes) {
      result.append(String.format("%02x", aByte));
    }
    return result.toString();
  }
}
