package eu.happycoders.adventofcode2015.day6;

import static eu.happycoders.adventofcode2015.day6.Command.TOGGLE;
import static eu.happycoders.adventofcode2015.day6.Command.TURN_OFF;
import static eu.happycoders.adventofcode2015.day6.Command.TURN_ON;

import java.util.Arrays;
import java.util.List;

class TestInputs {

  static final String TEST_INPUT =
      "turn on 0,0 through 999,999\n"
          + "toggle 0,0 through 999,0\n"
          + "turn off 499,499 through 500,500";

  static final List<Instruction> TEST_INSTRUCTIONS =
      Arrays.asList(
          new Instruction(TURN_ON, new Position(0, 0), new Position(999, 999)),
          new Instruction(TOGGLE, new Position(0, 0), new Position(999, 0)),
          new Instruction(TURN_OFF, new Position(499, 499), new Position(500, 500)));
}
