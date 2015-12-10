package eu.happycoders.adventofcode2015.common;

import static eu.happycoders.adventofcode2015.common.MedianCalculator.calculateMedian;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

class MedianCalculatorTest {

  @Test
  void givenZeroNumbers_calculateMedian_throwsException() {
    List<Long> values = Collections.emptyList();

    assertThatIllegalArgumentException().isThrownBy(() -> calculateMedian(values));
  }

  @Test
  void givenOneNumber_calculateMedian_returnsThatNumber() {
    List<Long> values = Collections.singletonList(5L);

    long median = calculateMedian(values);

    assertThat(median).isEqualTo(5);
  }

  @Test
  void givenTwoNumbers_calculateMedian_returnsTheMedian() {
    List<Long> values = Arrays.asList(555L, 777L);

    long median = calculateMedian(values);

    assertThat(median).isEqualTo(666L);
  }

  @Test
  void givenThreeNumbers_calculateMedian_returnsTheMedian() {
    List<Long> values = Arrays.asList(100L, 1000L, 10000L);

    long median = calculateMedian(values);

    assertThat(median).isEqualTo(1000L);
  }

  @Test
  void givenFourNumbers_calculateMedian_returnsTheMedian() {
    List<Long> values = Arrays.asList(100L, 500L, 600L, 700L);

    long median = calculateMedian(values);

    assertThat(median).isEqualTo(550L);
  }
}
