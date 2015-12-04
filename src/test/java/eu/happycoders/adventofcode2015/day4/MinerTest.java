package eu.happycoders.adventofcode2015.day4;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MinerTest {

  private static Stream<Arguments> secretKeysAndNumbersWith5ZeroMd5Hash() {
    return Stream.of(
        Arguments.of("abcdef", 609043), //
        Arguments.of("pqrstuv", 1048970));
  }

  @ParameterizedTest
  @MethodSource("secretKeysAndNumbersWith5ZeroMd5Hash")
  void givenASecretKeyAndANumber_md5HashStartsWith5Zeros_returnsTrue(String secretKey, int number) {
    boolean startsWith5Zeros = Miner.md5HashStartsWithZeros(secretKey, number, 5);

    assertThat(startsWith5Zeros).isTrue();
  }

  @ParameterizedTest
  @MethodSource("secretKeysAndNumbersWith5ZeroMd5Hash")
  void givenASecretKeyAndANumber_md5HashStartsWith6Zeros_returnsFalse(
      String secretKey, int number) {
    boolean startsWith5Zeros = Miner.md5HashStartsWithZeros(secretKey, number, 6);

    assertThat(startsWith5Zeros).isFalse();
  }

  @ParameterizedTest
  @MethodSource("secretKeysAndNumbersWith5ZeroMd5Hash")
  void givenASecretKey_mine_returnsNumber(String secretKey, int expectedNumber) {
    int number = Miner.mine(secretKey, 5);

    assertThat(number).isEqualTo(expectedNumber);
  }

  private static Stream<Arguments> hashWithRequiredZeros() {
    return Stream.of(
        Arguments.of(new byte[] {0, 0, (byte) 0xbb}, 3, true),
        Arguments.of(new byte[] {0, 0, (byte) 0xbb}, 4, true),
        Arguments.of(new byte[] {0, 0, (byte) 0xbb}, 5, false),
        Arguments.of(new byte[] {0, 0, 0x0b}, 4, true),
        Arguments.of(new byte[] {0, 0, 0x0b}, 5, true),
        Arguments.of(new byte[] {0, 0, 0x0b}, 6, false));
  }

  @ParameterizedTest
  @MethodSource("hashWithRequiredZeros")
  void givenAHash_byteArrayStartWithZeros_returnsExpectedResult(
      byte[] hash, int zeros, boolean expectedResult) {
    boolean startsWithZeros = Miner.hashStartWithZeros(hash, zeros);

    assertThat(startsWithZeros).isEqualTo(expectedResult);
  }
}
