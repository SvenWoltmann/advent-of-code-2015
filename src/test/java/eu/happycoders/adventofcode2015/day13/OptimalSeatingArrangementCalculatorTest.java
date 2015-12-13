package eu.happycoders.adventofcode2015.day13;

import static eu.happycoders.adventofcode2015.day13.TestInputs.TEST_POTENTIAL_HAPPINESSES;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class OptimalSeatingArrangementCalculatorTest {

  @Test
  void
      givenAnOptimalSeatingArrangementCalculatorWithTestData_calculateOptimalSeatingArrangement_returns330() {
    OptimalSeatingArrangementCalculator optimalSeatingArrangementCalculator =
        new OptimalSeatingArrangementCalculator(TEST_POTENTIAL_HAPPINESSES);

    int totalChangeInHappiness =
        optimalSeatingArrangementCalculator.calculateOptimalSeatingArrangement();

    assertThat(totalChangeInHappiness).isEqualTo(330);
  }
}
