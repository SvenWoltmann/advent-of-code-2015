package eu.happycoders.adventofcode2015.day19;

import static java.util.Collections.emptyList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>The nuclear fusion/fission plant, capable of constructing any Red-Nosed Reindeer molecule you
 * need.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class NuclearPlant {

  private static final Molecule ELECTRON = new Molecule("e");

  private final Map<String, List<Molecule>> replacementsPerAtom;
  private final Map<Integer, Map<Molecule, String>>
      reverseReplacementsPerReplacementLengthAndMolecule;
  private final int maxReplacementTargetMoleculeLength;

  private Map<Molecule, Integer> minimumStepsToMolecule;
  private int minDepth;

  NuclearPlant(List<Replacement> replacements) {
    this.replacementsPerAtom =
        replacements.stream()
            .collect(
                Collectors.groupingBy(
                    Replacement::from, Collectors.mapping(Replacement::to, Collectors.toList())));

    this.reverseReplacementsPerReplacementLengthAndMolecule = new HashMap<>();
    for (Replacement replacement : replacements) {
      Molecule toMolecule = replacement.to();
      Map<Molecule, String> moleculeToAtom =
          reverseReplacementsPerReplacementLengthAndMolecule.computeIfAbsent(
              toMolecule.getNumberOfAtoms(), ignore -> new HashMap<>());
      if (moleculeToAtom.containsKey(toMolecule)) {
        throw new AssertionError(
            "Assertion failed: only one replacement creates a specific sub-molecule");
      }
      moleculeToAtom.put(toMolecule, replacement.from());
    }

    this.maxReplacementTargetMoleculeLength =
        Collections.max(reverseReplacementsPerReplacementLengthAndMolecule.keySet());
  }

  int countDistinctMoleculesAfterOneReplacement(Molecule molecule) {
    return findNewMoleculesAfterOneReplacement(molecule).size();
  }

  private Set<Molecule> findNewMoleculesAfterOneReplacement(Molecule molecule) {
    Set<Molecule> result = new HashSet<>();

    for (int i = 0; i < molecule.getNumberOfAtoms(); i++) {
      String atom = molecule.atomAt(i);
      List<Molecule> replacements = replacementsPerAtom.getOrDefault(atom, emptyList());
      for (Molecule replacement : replacements) {
        Molecule newMolecule = molecule.replaceAtomByMolecule(i, replacement);
        result.add(newMolecule);
      }
    }

    return result;
  }

  private List<Molecule> findNewMoleculesAfterOneReverseReplacement(Molecule molecule) {
    Set<Molecule> result = new LinkedHashSet<>();
    int numberOfAtoms = molecule.getNumberOfAtoms();

    for (int subMoleculeLength = maxReplacementTargetMoleculeLength;
        subMoleculeLength >= 1;
        subMoleculeLength--) {
      Set<Molecule> replacementsForSubMoleculeLength =
          getReplacementsForSubMoleculeLength(molecule, numberOfAtoms, subMoleculeLength);
      result.addAll(replacementsForSubMoleculeLength);
    }

    return new ArrayList<>(result);
  }

  private Set<Molecule> getReplacementsForSubMoleculeLength(
      Molecule molecule, int numberOfAtoms, int subMoleculeLength) {
    Map<Molecule, String> moleculeToAtom =
        reverseReplacementsPerReplacementLengthAndMolecule.get(subMoleculeLength);
    if (moleculeToAtom == null) {
      return Collections.emptySet();
    }

    Set<Molecule> result = new HashSet<>();
    for (int index = 0; index <= numberOfAtoms - subMoleculeLength; index++) {
      Molecule subMolecule = molecule.subMoleculeAt(index, subMoleculeLength);
      String atom = moleculeToAtom.get(subMolecule);
      if (atom != null) {
        // Only the full molecule should be replaced by an electron
        if (atom.equals("e") && subMoleculeLength != numberOfAtoms) {
          continue;
        }
        Molecule newMolecule = molecule.replaceMoleculeByAtom(index, subMoleculeLength, atom);
        result.add(newMolecule);
      }
    }
    return result;
  }

  int getFewestNumberOfStepsToCreate(Molecule targetMolecule) {
    int result = targetMolecule.getNumberOfAtoms();
    for (int i = 0; i < targetMolecule.getNumberOfAtoms(); i++) {
      String atom = targetMolecule.atomAt(i);
      if (atom.equals("Rn") || atom.equals("Ar")) {
        result--;
      }
      if (atom.equals("Y")) {
        result -= 2;
      }
    }
    return result - 1;
  }

  int getFewestNumberOfStepsToCreateViaDepthFirstSearch(Molecule targetMolecule) {
    minimumStepsToMolecule = new HashMap<>();
    minDepth = Integer.MAX_VALUE;

    depthFirstSearchRecursive(targetMolecule, 0);

    return minDepth;
  }

  private void depthFirstSearchRecursive(Molecule targetMolecule, int depth) {
    Integer minimumStepsToTarget = minimumStepsToMolecule.get(targetMolecule);
    if (minimumStepsToTarget != null && minimumStepsToTarget <= depth) {
      return;
    }

    minimumStepsToMolecule.put(targetMolecule, depth);

    if (targetMolecule.equals(ELECTRON)) {
      if (depth < minDepth) {
        minDepth = depth;
      }
      return;
    }

    List<Molecule> newMoleculesAfterOneReverseReplacement =
        findNewMoleculesAfterOneReverseReplacement(targetMolecule);
    for (Molecule molecule : newMoleculesAfterOneReverseReplacement) {
      depthFirstSearchRecursive(molecule, depth + 1);
    }
  }
}
