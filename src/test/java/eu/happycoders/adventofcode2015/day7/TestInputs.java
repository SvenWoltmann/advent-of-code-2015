package eu.happycoders.adventofcode2015.day7;

import java.util.Arrays;
import java.util.List;

class TestInputs {

  static final String TEST_INPUT =
      "123 -> x\n"
          + "456 -> y\n"
          + "x AND y -> d\n"
          + "x OR y -> e\n"
          + "x LSHIFT 2 -> f\n"
          + "y RSHIFT 2 -> g\n"
          + "NOT x -> h\n"
          + "NOT y -> i";

  static final List<Instruction> TEST_INSTRUCTIONS =
      Arrays.asList(
          new Instruction(new SpecificValue(123), "x"),
          new Instruction(new SpecificValue(456), "y"),
          new Instruction(new AndGate(new Wire("x"), new Wire("y")), "d"),
          new Instruction(new OrGate(new Wire("x"), new Wire("y")), "e"),
          new Instruction(new LeftShiftGate(new Wire("x"), new SpecificValue(2)), "f"),
          new Instruction(new RightShiftGate(new Wire("y"), new SpecificValue(2)), "g"),
          new Instruction(new NotGate(new Wire("x")), "h"),
          new Instruction(new NotGate(new Wire("y")), "i"));
}
