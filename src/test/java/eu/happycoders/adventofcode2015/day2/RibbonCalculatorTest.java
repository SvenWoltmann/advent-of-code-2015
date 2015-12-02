package eu.happycoders.adventofcode2015.day2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RibbonCalculatorTest {

  @Test
  void givenDimensions2x3x4_calculateRequiredRibbonLength_returns_34() {
    Dimensions dimensions = new Dimensions(2, 3, 4);

    int requiredRibbonLength = RibbonCalculator.calculateRequiredRibbonLength(dimensions);

    assertThat(requiredRibbonLength).isEqualTo(34);
  }

  @Test
  void givenDimensions1x1x10_calculateRequiredRibbonLength_returns_14() {
    Dimensions dimensions = new Dimensions(1, 1, 10);

    int requiredRibbonLength = RibbonCalculator.calculateRequiredRibbonLength(dimensions);

    assertThat(requiredRibbonLength).isEqualTo(14);
  }
}
