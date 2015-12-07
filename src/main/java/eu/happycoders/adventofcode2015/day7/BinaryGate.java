package eu.happycoders.adventofcode2015.day7;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>A binary gate, that's a gate with two input sources.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
abstract class BinaryGate extends Gate {

  final GateInput gateInput1;
  final GateInput gateInput2;

  BinaryGate(GateInput gateInput1, GateInput gateInput2) {
    this.gateInput1 = gateInput1;
    this.gateInput2 = gateInput2;
  }

  @Override
  int applyOperation() {
    return applyOperation(gateInput1.getSignal(), gateInput2.getSignal());
  }

  abstract int applyOperation(int signal1, int signal2);

  @Override
  public void reset() {
    signal = null;
    gateInput1.reset();
    gateInput2.reset();
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }

    BinaryGate that = (BinaryGate) object;
    return gateInput1.equals(that.gateInput1) && gateInput2.equals(that.gateInput2);
  }

  @Override
  public int hashCode() {
    int result = gateInput1.hashCode();
    result = 31 * result + gateInput2.hashCode();
    return result;
  }
}
