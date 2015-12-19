package eu.happycoders.adventofcode2015.day19;

import java.util.Arrays;
import java.util.List;

class TestInputs {

  static final String TEST_INPUT =
      "H => HO\n" //
          + "H => OH\n"
          + "O => HH\n"
          + "\n"
          + "HOH";

  static final String TEST_INPUT_PART3 =
      "e => HO\n" //
          + "H => HRnOAr\n"
          + "H => HRnHYOAr\n"
          + "H => OH\n"
          + "O => HH\n"
          + "\n"
          + "OHOHRnHRnHHArYHHArOH";

  static final List<Replacement> TEST_REPLACEMENTS =
      Arrays.asList(
          new Replacement("H", "HO"), //
          new Replacement("H", "OH"),
          new Replacement("O", "HH"));

  static final List<Replacement> TEST_REPLACEMENTS_PART2 =
      Arrays.asList(
          new Replacement("e", "H"),
          new Replacement("e", "O"),
          new Replacement("H", "HO"),
          new Replacement("H", "OH"),
          new Replacement("O", "HH"));

  static final List<Replacement> TEST_REPLACEMENTS_PART3 =
      Arrays.asList(
          new Replacement("e", "HO"),
          new Replacement("H", "HRnOAr"),
          new Replacement("H", "HRnHYOAr"),
          new Replacement("H", "OH"),
          new Replacement("O", "HH"));
  static final Molecule TEST_MOLECULE = new Molecule("HOH");

  static final PuzzleInput TEST_PUZZLE_INPUT = new PuzzleInput(TEST_REPLACEMENTS, TEST_MOLECULE);
}
