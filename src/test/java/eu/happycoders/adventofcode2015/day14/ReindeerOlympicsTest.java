package eu.happycoders.adventofcode2015.day14;

import static eu.happycoders.adventofcode2015.day14.TestInputs.TEST_REINDEER;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ReindeerOlympicsTest {

  @Test
  void givenAReindeerHerdWithTestReindeer_getFarthestDistanceAfter1000Seconds_returns1120() {
    ReindeerOlympics reindeerOlympics = new ReindeerOlympics(TEST_REINDEER);

    int farthestDistance = reindeerOlympics.getFarthestDistanceAfterSeconds(1000);

    assertThat(farthestDistance).isEqualTo(1120);
  }

  @Test
  void givenAReindeerHerdWithTestReindeer_getMostPointsAfter1000Seconds_returns689() {
    ReindeerOlympics reindeerOlympics = new ReindeerOlympics(TEST_REINDEER);

    int farthestDistance = reindeerOlympics.getMostPointsAfterSeconds(1000);

    assertThat(farthestDistance).isEqualTo(689);
  }
}
