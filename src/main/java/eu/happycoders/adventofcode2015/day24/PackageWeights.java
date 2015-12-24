package eu.happycoders.adventofcode2015.day24;

import java.util.List;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>The package weights; with flags indicating whether a package to used.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class PackageWeights {

  private final int[] weights;
  private final int size;
  private final boolean[] used;

  PackageWeights(List<Integer> weights) {
    this(toArray(weights));
  }

  private static int[] toArray(List<Integer> weights) {
    int size = weights.size();
    int[] result = new int[size];
    for (int i = 0; i < size; i++) {
      result[i] = weights.get(i);
    }
    return result;
  }

  PackageWeights(int[] weights) {
    this.weights = weights;
    this.size = weights.length;
    this.used = new boolean[size];
  }

  int get(int index) {
    return weights[index];
  }

  void setUsed(int index) {
    used[index] = true;
  }

  void setUnused(int index) {
    used[index] = false;
  }

  boolean isUnused(int index) {
    return !used[index];
  }

  int size() {
    return size;
  }

  int getSumOfRemainingWeights() {
    // This is called rarely, so we don't have to keep track of this value
    int result = 0;
    for (int i = 0; i < size; i++) {
      if (!used[i]) {
        result += weights[i];
      }
    }
    return result;
  }
}
