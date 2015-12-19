package eu.happycoders.adventofcode2015.day19;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>An (immutable) molecule.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class Molecule {

  // Possible atoms:
  // * one uppercase letter
  // * one uppercase and one lowercase letter with the latter not being 'e'
  // * 'e' (electron)
  private static final Pattern ATOM_PATTERN = Pattern.compile("[A-Z][a-df-z]|[A-Z]|e");

  private final List<String> atoms;

  Molecule(String value) {
    this.atoms = splitIntoAtoms(value);
  }

  Molecule(List<String> atoms) {
    this.atoms = atoms;
  }

  private List<String> splitIntoAtoms(String value) {
    List<String> result = new ArrayList<>();
    Matcher matcher = ATOM_PATTERN.matcher(value);
    while (matcher.find()) {
      result.add(matcher.group());
    }
    return result;
  }

  int getNumberOfAtoms() {
    return atoms.size();
  }

  String atomAt(int index) {
    return atoms.get(index);
  }

  Molecule replaceAtomByMolecule(int index, Molecule replacement) {
    List<String> result = new ArrayList<>();
    result.addAll(atoms.subList(0, index));
    result.addAll(replacement.atoms);
    result.addAll(atoms.subList(index + 1, atoms.size()));
    return new Molecule(result);
  }

  Molecule subMoleculeAt(int index, int subMoleculeLength) {
    return new Molecule(atoms.subList(index, index + subMoleculeLength));
  }

  Molecule replaceMoleculeByAtom(int index, int subMoleculeLength, String atom) {
    List<String> result = new ArrayList<>();
    result.addAll(atoms.subList(0, index));
    result.add(atom);
    result.addAll(atoms.subList(index + subMoleculeLength, atoms.size()));
    return new Molecule(result);
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    Molecule that = (Molecule) object;
    return atoms.equals(that.atoms);
  }

  @Override
  public int hashCode() {
    return Objects.hash(atoms);
  }

  @Override
  public String toString() {
    return String.join("", atoms);
  }
}
