package eu.happycoders.adventofcode2015.day24;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Calculates the optimal distribution of packages on the sleigh.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class SleighBalancer {

  private final PackageWeights packageWeights;
  private final int requiredWeightSumPerCompartment;

  private int bestResultNumberOfPackages = Integer.MAX_VALUE;
  private long bestResultQe = Long.MAX_VALUE;

  SleighBalancer(List<Integer> packageWeights, int numberOfCompartments) {
    this.packageWeights = new PackageWeights(sortDescending(packageWeights));
    int sumOfPackageWeights = sum(packageWeights);
    if (sumOfPackageWeights % numberOfCompartments != 0) {
      throw new IllegalArgumentException(
          "Sum of package weights not dividable by number of compartments");
    }
    this.requiredWeightSumPerCompartment = sumOfPackageWeights / numberOfCompartments;
  }

  private static List<Integer> sortDescending(List<Integer> packageWeights) {
    return packageWeights.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
  }

  private static int sum(List<Integer> packageWeights) {
    return packageWeights.stream().mapToInt(Integer::intValue).sum();
  }

  long findIdealConfigurationQe() {
    recurse(0, 0, 1);
    return bestResultQe;
  }

  private void recurse(
      int currentNumberOfPackages, int currentSumOfPackageWeights, long currentQe) {
    if (currentNumberOfPackages >= bestResultNumberOfPackages
        && currentSumOfPackageWeights != requiredWeightSumPerCompartment) {
      return;
    }

    if (currentSumOfPackageWeights == requiredWeightSumPerCompartment) {
      if (isNewBestResult(currentNumberOfPackages, currentQe)) {
        bestResultNumberOfPackages = currentNumberOfPackages;
        bestResultQe = currentQe;
      }
      return;
    }

    for (int i = 0; i < packageWeights.size(); i++) {
      if (packageWeights.isUnused(i)) {
        int packageWeight = packageWeights.get(i);
        int newSumOfPackageWeights = currentSumOfPackageWeights + packageWeight;
        if (newSumOfPackageWeights <= requiredWeightSumPerCompartment) {
          packageWeights.setUsed(i);
          recurse(currentNumberOfPackages + 1, newSumOfPackageWeights, currentQe * packageWeight);
          packageWeights.setUnused(i);
        }
      }
    }
  }

  private boolean isNewBestResult(int currentNumberOfPackages, long currentQe) {
    return (currentNumberOfPackages < bestResultNumberOfPackages
            || currentNumberOfPackages == bestResultNumberOfPackages && currentQe < bestResultQe)
        && canTheRestBeSplitUp();
  }

  private boolean canTheRestBeSplitUp() {
    return recurseToFindWeightCombination(0);
  }

  @SuppressWarnings("PMD.CognitiveComplexity") // Cognitive complexity is exactly at the limit
  private boolean recurseToFindWeightCombination(int currentSumOfPackageWeights) {
    if (currentSumOfPackageWeights == requiredWeightSumPerCompartment) {
      // How much is remaining?
      int remainingWeight = packageWeights.getSumOfRemainingWeights();
      if (remainingWeight == requiredWeightSumPerCompartment) {
        return true;
      } else {
        return canTheRestBeSplitUp();
      }
    }

    for (int i = 0; i < packageWeights.size(); i++) {
      if (packageWeights.isUnused(i)) {
        int newSumOfPackageWeights = currentSumOfPackageWeights + packageWeights.get(i);
        if (newSumOfPackageWeights <= requiredWeightSumPerCompartment) {
          packageWeights.setUsed(i);
          boolean resultFound = recurseToFindWeightCombination(newSumOfPackageWeights);
          packageWeights.setUnused(i);
          if (resultFound) {
            return true;
          }
        }
      }
    }
    return false;
  }
}
