package eu.happycoders.adventofcode2015.day5;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NiceStringDetectorPart1Test {

  private final NiceStringDetectorPart1 detector = new NiceStringDetectorPart1();

  @ParameterizedTest
  @ValueSource(strings = {"ugknbfddgicrmopn", "aaa"})
  void givenANiceString_isNice_returnsTrue(String string) {
    boolean nice = detector.test(string);

    assertThat(nice).isTrue();
  }

  @ParameterizedTest
  @ValueSource(strings = {"jchzalrnumimnmhp", "haegwjzuvuyypxyu", "dvszwmarrgswjxmb"})
  void givenANaughtyString_isNice_returnsFalse(String string) {
    boolean nice = detector.test(string);

    assertThat(nice).isFalse();
  }
}
