package eu.happycoders.adventofcode2015.day7;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>A specific value fed into a {@link Wire} or {@link Gate}.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class SpecificValue implements WireSource, GateInput {

  final int signal;

  SpecificValue(int signal) {
    this.signal = signal;
  }

  @Override
  public int getSignal() {
    return signal;
  }

  @Override
  public void reset() {
    // A hardcoded signal cannot be reset
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }

    SpecificValue that = (SpecificValue) object;
    return signal == that.signal;
  }

  @Override
  public int hashCode() {
    return signal;
  }

  @Override
  public String toString() {
    return String.valueOf(signal);
  }
}
