package eu.happycoders.adventofcode2015.day9;

import java.util.Arrays;
import java.util.List;

class TestInputs {

  static final String TEST_INPUT =
      "London to Dublin = 464\n" //
          + "London to Belfast = 518\n"
          + "Dublin to Belfast = 141";

  static final List<Path> TEST_PATHS =
      Arrays.asList(
          new Path("London", "Dublin", 464),
          new Path("London", "Belfast", 518),
          new Path("Dublin", "Belfast", 141));
}
