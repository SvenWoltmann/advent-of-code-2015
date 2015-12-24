package eu.happycoders.adventofcode2015.day24;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SleighBalancerTest {

  @Test
  void givenASleighBalancerWithTestWeightsAnd3Compartments_findIdealConfigurationQE_returns99() {
    SleighBalancer sleighBalancer = new SleighBalancer(TestInputs.TEST_WEIGHTS, 3);

    long idealConfigurationQE = sleighBalancer.findIdealConfigurationQe();

    assertThat(idealConfigurationQE).isEqualTo(99L);
  }

  @Test
  void givenASleighBalancerWithTestWeightsAnd4Compartments_findIdealConfigurationQE_returns44() {
    SleighBalancer sleighBalancer = new SleighBalancer(TestInputs.TEST_WEIGHTS, 4);

    long idealConfigurationQE = sleighBalancer.findIdealConfigurationQe();

    assertThat(idealConfigurationQE).isEqualTo(44L);
  }
}
