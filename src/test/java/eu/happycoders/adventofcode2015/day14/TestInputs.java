package eu.happycoders.adventofcode2015.day14;

import java.util.Arrays;
import java.util.List;

class TestInputs {

  static final String TEST_INPUT =
      "Comet can fly 14 km/s for 10 seconds, but then must rest for 127 seconds.\n"
          + "Dancer can fly 16 km/s for 11 seconds, but then must rest for 162 seconds.";

  static final Reindeer COMET = new Reindeer("Comet", 14, 10, 127);
  static final Reindeer DANCER = new Reindeer("Dancer", 16, 11, 162);

  static final List<Reindeer> TEST_REINDEER = Arrays.asList(COMET, DANCER);
}
