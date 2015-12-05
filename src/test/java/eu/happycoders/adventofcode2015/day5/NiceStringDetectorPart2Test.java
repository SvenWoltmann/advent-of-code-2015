package eu.happycoders.adventofcode2015.day5;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NiceStringDetectorPart2Test {

  private final NiceStringDetectorPart2 detector = new NiceStringDetectorPart2();

  @ParameterizedTest
  @ValueSource(strings = {"qjhvhtzxzqqjkmpb", "xxyxx"})
  void givenANiceString_isNice_returnsTrue(String string) {
    boolean nice = detector.test(string);

    assertThat(nice).isTrue();
  }

  @ParameterizedTest
  @ValueSource(strings = {"uurcxstgmygtbstg", "ieodomkazucvgmuy", "aaa"})
  void givenANaughtyString_isNice_returnsFalse(String string) {
    boolean nice = detector.test(string);

    assertThat(nice).isFalse();
  }
}
