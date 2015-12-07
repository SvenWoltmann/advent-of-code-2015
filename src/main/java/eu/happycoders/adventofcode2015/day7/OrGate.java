package eu.happycoders.adventofcode2015.day7;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>A binary gate applying the "or" operation.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class OrGate extends BinaryGate {

  OrGate(GateInput gateInput1, GateInput gateInput2) {
    super(gateInput1, gateInput2);
  }

  @Override
  int applyOperation(int signal1, int signal2) {
    return signal1 | signal2;
  }

  @Override
  public String toString() {
    return gateInput1 + " OR " + gateInput2;
  }
}
