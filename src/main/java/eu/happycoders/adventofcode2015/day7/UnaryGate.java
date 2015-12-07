package eu.happycoders.adventofcode2015.day7;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>A unary gate, that's a gate with one input source.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
abstract class UnaryGate extends Gate {

  final GateInput gateInput;

  UnaryGate(GateInput gateInput) {
    this.gateInput = gateInput;
  }

  @Override
  int applyOperation() {
    return applyOperation(gateInput.getSignal());
  }

  abstract int applyOperation(int signal1);

  @Override
  public void reset() {
    signal = null;
    gateInput.reset();
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }

    UnaryGate that = (UnaryGate) object;
    return gateInput.equals(that.gateInput);
  }

  @Override
  public int hashCode() {
    return gateInput.hashCode();
  }
}
