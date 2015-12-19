package eu.happycoders.adventofcode2015.day19;

import java.util.List;
import java.util.Objects;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>The puzzle input consisting of a list of {@link Replacement}s and a {@link Molecule}.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class PuzzleInput {

  private final List<Replacement> replacements;
  private final Molecule molecule;

  PuzzleInput(List<Replacement> replacements, Molecule molecule) {
    this.replacements = replacements;
    this.molecule = molecule;
  }

  List<Replacement> replacements() {
    return replacements;
  }

  Molecule molecule() {
    return molecule;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    PuzzleInput that = (PuzzleInput) object;
    return replacements.equals(that.replacements) && molecule.equals(that.molecule);
  }

  @Override
  public int hashCode() {
    return Objects.hash(replacements, molecule);
  }
}
