package eu.happycoders.adventofcode2015.day19;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class NuclearPlantTest {

  @Test
  void
      givenANuclearPlantWithTheTestReplacements_countDistinctMoleculesAfterOneReplacementForHOH_returns4() {
    NuclearPlant nuclearPlant = new NuclearPlant(TestInputs.TEST_REPLACEMENTS);

    int numberOfDistinctMolecules =
        nuclearPlant.countDistinctMoleculesAfterOneReplacement(new Molecule("HOH"));

    assertThat(numberOfDistinctMolecules).isEqualTo(4);
  }

  @Test
  void
      givenANuclearPlantWithTheTestReplacements_countDistinctMoleculesAfterOneReplacementForHOHOHO_returns7() {
    NuclearPlant nuclearPlant = new NuclearPlant(TestInputs.TEST_REPLACEMENTS);

    int numberOfDistinctMolecules =
        nuclearPlant.countDistinctMoleculesAfterOneReplacement(new Molecule("HOHOHO"));

    assertThat(numberOfDistinctMolecules).isEqualTo(7);
  }

  @Test
  void
      givenANuclearPlantWithTheTestReplacementsForPart2_getFewestNumberOfStepsToCreateViaDepthFirstSearchHOH_returns3() {
    NuclearPlant nuclearPlant = new NuclearPlant(TestInputs.TEST_REPLACEMENTS_PART2);

    int fewestNumberOfSteps =
        nuclearPlant.getFewestNumberOfStepsToCreateViaDepthFirstSearch(new Molecule("HOH"));

    assertThat(fewestNumberOfSteps).isEqualTo(3);
  }

  @Test
  void
      givenANuclearPlantWithTheTestReplacementsForPart2_getFewestNumberOfStepsToCreateViaDepthFirstSearchHOHOHO_returns6() {
    NuclearPlant nuclearPlant = new NuclearPlant(TestInputs.TEST_REPLACEMENTS_PART2);

    int fewestNumberOfSteps =
        nuclearPlant.getFewestNumberOfStepsToCreateViaDepthFirstSearch(new Molecule("HOHOHO"));

    assertThat(fewestNumberOfSteps).isEqualTo(6);
  }

  @Test
  void
      givenANuclearPlantWithTheTestReplacementsForPart3_getFewestNumberOfStepsToCreateViaDepthFirstSearchHOHOHO_returns6() {
    NuclearPlant nuclearPlant = new NuclearPlant(TestInputs.TEST_REPLACEMENTS_PART3);

    int fewestNumberOfSteps =
        nuclearPlant.getFewestNumberOfStepsToCreateViaDepthFirstSearch(
            new Molecule("OHOHRnHRnHHArYHHArOH"));

    assertThat(fewestNumberOfSteps).isEqualTo(9);
  }

  @Test
  void givenANuclearPlantWithTheTestReplacementsForPart3_getFewestNumberOfStepsToCreate_returns6() {
    NuclearPlant nuclearPlant = new NuclearPlant(TestInputs.TEST_REPLACEMENTS_PART3);

    int fewestNumberOfSteps =
        nuclearPlant.getFewestNumberOfStepsToCreate(new Molecule("OHOHRnHRnHHArYHHArOH"));

    assertThat(fewestNumberOfSteps).isEqualTo(9);
  }
}
