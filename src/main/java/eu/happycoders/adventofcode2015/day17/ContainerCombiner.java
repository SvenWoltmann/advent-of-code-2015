package eu.happycoders.adventofcode2015.day17;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Calculates all combinations of containers and finds the ones with the requested combined
 * volume.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class ContainerCombiner {

  private final List<Integer> containerSizes;
  private final int numberOfContainers;
  private final int[] smallestVolumeOfRemainingContainers;
  private final int[] totalVolumeOfRemainingsContainers;

  private int requestedVolume;
  private int numberOfCombinations;
  private Map<Integer, Integer> numberOfCombinationsPerNumberOfContainers;
  private int minimumNumberOfUsedContainers;

  ContainerCombiner(List<Integer> containerSizes) {
    this.containerSizes = containerSizes;
    this.numberOfContainers = containerSizes.size();
    this.smallestVolumeOfRemainingContainers = new int[numberOfContainers];
    this.totalVolumeOfRemainingsContainers = new int[numberOfContainers];

    calculateSmallestVolumeAndTotalVolumeOfRemainingContainers();
  }

  private void calculateSmallestVolumeAndTotalVolumeOfRemainingContainers() {
    int lastIndex = numberOfContainers - 1;
    int lastContainerSize = containerSizes.get(lastIndex);
    smallestVolumeOfRemainingContainers[lastIndex] = lastContainerSize;
    totalVolumeOfRemainingsContainers[lastIndex] = lastContainerSize;

    for (int i = lastIndex - 1; i >= 0; i--) {
      int containerSize = containerSizes.get(i);
      smallestVolumeOfRemainingContainers[i] =
          Math.min(smallestVolumeOfRemainingContainers[i + 1], containerSize);
      totalVolumeOfRemainingsContainers[i] =
          totalVolumeOfRemainingsContainers[i + 1] + containerSize;
    }
  }

  void findAllPossibleCombinations(int requestedVolume) {
    this.requestedVolume = requestedVolume;
    numberOfCombinations = 0;
    numberOfCombinationsPerNumberOfContainers = new HashMap<>();
    minimumNumberOfUsedContainers = Integer.MAX_VALUE;

    tryAllCombinationsRecursively(0, 0, 0);
  }

  private void tryAllCombinationsRecursively(
      int currentContainerIndex, int numberOfUsedContainers, int reachedVolume) {
    if (reachedVolume == requestedVolume) {
      numberOfCombinations++;
      numberOfCombinationsPerNumberOfContainers.compute(
          numberOfUsedContainers, (key, oldValue) -> oldValue == null ? 1 : oldValue + 1);
      if (numberOfUsedContainers < minimumNumberOfUsedContainers) {
        minimumNumberOfUsedContainers = numberOfUsedContainers;
      }
      return;
    }

    if (canAbortThisPath(currentContainerIndex, reachedVolume)) {
      return;
    }

    // Try *without* container at current index
    tryAllCombinationsRecursively(currentContainerIndex + 1, numberOfUsedContainers, reachedVolume);

    // Try *with* container at current index
    tryAllCombinationsRecursively(
        currentContainerIndex + 1,
        numberOfUsedContainers + 1,
        reachedVolume + containerSizes.get(currentContainerIndex));
  }

  private boolean canAbortThisPath(int currentContainerIndex, int reachedVolume) {
    return currentContainerIndex == numberOfContainers
        || reachedVolume > requestedVolume
        || addingTheSmallestRemainingContainerWouldExceedTheRequestedVolume(
            currentContainerIndex, reachedVolume)
        || addingAllRemainingContainersWouldNotBeEnough(currentContainerIndex, reachedVolume);
  }

  private boolean addingTheSmallestRemainingContainerWouldExceedTheRequestedVolume(
      int currentContainerIndex, int reachedVolume) {
    return reachedVolume + smallestVolumeOfRemainingContainers[currentContainerIndex]
        > requestedVolume;
  }

  private boolean addingAllRemainingContainersWouldNotBeEnough(
      int currentContainerIndex, int reachedVolume) {
    return reachedVolume + totalVolumeOfRemainingsContainers[currentContainerIndex]
        < requestedVolume;
  }

  int getNumberOfCombinations() {
    return numberOfCombinations;
  }

  int getNumberOfCombinationsWithFewestNumberOfContainers() {
    return numberOfCombinationsPerNumberOfContainers.get(minimumNumberOfUsedContainers);
  }
}
