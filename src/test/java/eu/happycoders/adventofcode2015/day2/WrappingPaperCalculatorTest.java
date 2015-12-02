package eu.happycoders.adventofcode2015.day2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class WrappingPaperCalculatorTest {

  @Test
  void givenDimensions2x3x4_calculateRequiredWrappingPaperSize_returns_58() {
    Dimensions dimensions = new Dimensions(2, 3, 4);

    int requiredWrappingPaper =
        WrappingPaperCalculator.calculateRequiredWrappingPaperSize(dimensions);

    assertThat(requiredWrappingPaper).isEqualTo(58);
  }

  @Test
  void givenDimensions1x1x10_calculateRequiredWrappingPaperSize_returns_43() {
    Dimensions dimensions = new Dimensions(1, 1, 10);

    int requiredWrappingPaper =
        WrappingPaperCalculator.calculateRequiredWrappingPaperSize(dimensions);

    assertThat(requiredWrappingPaper).isEqualTo(43);
  }
}
