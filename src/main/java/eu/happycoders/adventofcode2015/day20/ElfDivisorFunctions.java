package eu.happycoders.adventofcode2015.day20;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Elf-specific "divisor function" calculations.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class ElfDivisorFunctions {

  static int findLowestHouseNoForSumOfPresents(
      int minNoOfPresents, int maxHousesPerElf, int elfMultiple) {
    int maxHousesTotal = minNoOfPresents / elfMultiple - 1;
    int[] presentsPerHouse =
        calculatePresentsPerHouse(maxHousesTotal, maxHousesPerElf, elfMultiple);

    for (int n = 1; n <= maxHousesTotal; n++) {
      if (presentsPerHouse[n - 1] >= minNoOfPresents) {
        return n;
      }
    }

    throw new AssertionError("A solution should have been found.");
  }

  static int[] calculatePresentsPerHouse(int maxHousesTotal, int maxHousesPerElf, int elfMultiple) {
    int[] presents = new int[maxHousesTotal];
    for (int elf = 1; elf <= maxHousesTotal; elf++) {
      int housesThisElf = 0;
      for (int houseNo = elf; houseNo <= maxHousesTotal; houseNo += elf) {
        presents[houseNo - 1] = presents[houseNo - 1] + elf * elfMultiple;

        housesThisElf++;
        if (housesThisElf == maxHousesPerElf) {
          break;
        }
      }
    }
    return presents;
  }
}
