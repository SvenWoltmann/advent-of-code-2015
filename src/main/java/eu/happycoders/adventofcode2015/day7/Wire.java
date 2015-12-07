package eu.happycoders.adventofcode2015.day7;

import java.util.Objects;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>A wire with an ID fed into another wire or a {@link Gate}.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class Wire implements WireSource, GateInput {

  private final String id;

  private WireSource wireSource;

  private Integer signal;

  Wire(String id) {
    this.id = id;
  }

  String id() {
    return id;
  }

  void setWireSource(WireSource wireSource) {
    Objects.requireNonNull(wireSource);
    this.wireSource = wireSource;
  }

  @Override
  public int getSignal() {
    if (signal == null) {
      if (wireSource == null) {
        throw new IllegalStateException("Wire " + id + " not wired up");
      }

      signal = wireSource.getSignal();
    }
    return signal;
  }

  @Override
  public void reset() {
    signal = null;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }

    Wire that = (Wire) object;
    return id.equals(that.id);
  }

  @Override
  public int hashCode() {
    return id.hashCode();
  }

  @Override
  public String toString() {
    return id;
  }
}
