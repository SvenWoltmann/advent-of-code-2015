package eu.happycoders.adventofcode2015.day7;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>A unary gate applying the "not" operation.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class NotGate extends UnaryGate {

  NotGate(GateInput gateInput) {
    super(gateInput);
  }

  @Override
  int applyOperation(int signal) {
    return (~signal) & 0xffff;
  }

  @Override
  public String toString() {
    return "NOT " + gateInput;
  }
}
