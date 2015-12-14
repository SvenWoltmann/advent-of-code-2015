package eu.happycoders.adventofcode2015.day14;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ReindeerTest {

  @Test
  void givenComet_getDistanceAfter1000Seconds_returns1120() {
    Reindeer comet = TestInputs.COMET;

    int distance = comet.getDistanceAfterSeconds(1000);

    assertThat(distance).isEqualTo(1120);
  }

  @Test
  void givenDancer_getDistanceAfter1000Seconds_returns1056() {
    Reindeer dancer = TestInputs.DANCER;

    int distance = dancer.getDistanceAfterSeconds(1000);

    assertThat(distance).isEqualTo(1056);
  }
}
