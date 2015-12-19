package eu.happycoders.adventofcode2015.day19;

import java.util.Objects;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>An atomic replacement within a molecule.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class Replacement {

  private final String from;
  private final Molecule to;

  Replacement(String from, String to) {
    this.from = from;
    this.to = new Molecule(to);
  }

  String from() {
    return from;
  }

  Molecule to() {
    return to;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    Replacement that = (Replacement) object;
    return from.equals(that.from) && to.equals(that.to);
  }

  @Override
  public int hashCode() {
    return Objects.hash(from, to);
  }
}
