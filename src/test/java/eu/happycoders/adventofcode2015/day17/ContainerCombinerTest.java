package eu.happycoders.adventofcode2015.day17;

import static eu.happycoders.adventofcode2015.day17.TestInputs.TEST_CONTAINER_SIZES;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ContainerCombinerTest {

  @Test
  void
      givenAContainerCombinerWithTheTestContainerSizes_findAllPossibleCombinations_getNumberOfCombinationsReturns4() {
    ContainerCombiner containerCombiner = new ContainerCombiner(TEST_CONTAINER_SIZES);

    containerCombiner.findAllPossibleCombinations(25);
    int numberOfCombinations = containerCombiner.getNumberOfCombinations();

    assertThat(numberOfCombinations).isEqualTo(4);
  }

  @Test
  void
      givenAContainerCombinerWithTheTestContainerSizes_findAllPossibleCombinations_getNumberOfCombinationsWithFewestNumberOfContainersReturns3() {
    ContainerCombiner containerCombiner = new ContainerCombiner(TEST_CONTAINER_SIZES);

    containerCombiner.findAllPossibleCombinations(25);
    int numberOfCombinations =
        containerCombiner.getNumberOfCombinationsWithFewestNumberOfContainers();

    assertThat(numberOfCombinations).isEqualTo(3);
  }
}
