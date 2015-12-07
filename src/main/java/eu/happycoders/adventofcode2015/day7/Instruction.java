package eu.happycoders.adventofcode2015.day7;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>An instruction to connect some {@link WireSource} ({@link Gate}, {@link Wire}, or {@link
 * SpecificValue}) value to a destination wire.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class Instruction {

  private final WireSource wireSource;
  private final String destinationWireId;

  Instruction(WireSource wireSource, String destinationWireId) {
    this.wireSource = wireSource;
    this.destinationWireId = destinationWireId;
  }

  WireSource wireSource() {
    return wireSource;
  }

  String destinationWireId() {
    return destinationWireId;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }

    Instruction that = (Instruction) object;
    return wireSource.equals(that.wireSource) && destinationWireId.equals(that.destinationWireId);
  }

  @Override
  public int hashCode() {
    int result = wireSource.hashCode();
    result = 31 * result + destinationWireId.hashCode();
    return result;
  }

  @Override
  public String toString() {
    return wireSource + " -> " + destinationWireId;
  }
}
