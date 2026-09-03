package eu.happycoders.adventofcode2015.day20;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ElfDivisorFunctionsTest {

  @ParameterizedTest(
      name = "with unlimited houses per elf, house {1} is the first to get {0} presents")
  @CsvSource({"100, 6", "1000, 48", "10000, 360"})
  void
      findLowestHouseNoForSumOfPresents_unlimitedHousesPerElfAndElfMultiple10_returnsTheLowestHouse(
          int minPresents, int expectedHouseNo) {
    int lowestN =
        ElfDivisorFunctions.findLowestHouseNoForSumOfPresents(minPresents, Integer.MAX_VALUE, 10);

    assertThat(lowestN).isEqualTo(expectedHouseNo);
  }

  @ParameterizedTest(name = "with 5 houses per elf, house {1} is the first to get {0} presents")
  @CsvSource({"100, 4", "1000, 24", "10000, 240"})
  void findLowestHouseNoForSumOfPresents_maxHousesPerElf5AndElfMultiple20_returnsTheLowestHouse(
      int minPresents, int expectedHouseNo) {
    int lowestN = ElfDivisorFunctions.findLowestHouseNoForSumOfPresents(minPresents, 5, 20);

    assertThat(lowestN).isEqualTo(expectedHouseNo);
  }

  @Test
  void givenMaxHousesTotal10AndMultiple10_calculatePresentsPerHouse_returnsTheFirstTenSums() {
    int maxHousesTotal = 10;

    int[] sums =
        ElfDivisorFunctions.calculatePresentsPerHouse(maxHousesTotal, Integer.MAX_VALUE, 10);

    assertThat(sums).containsExactly(10, 30, 40, 70, 60, 120, 80, 150, 130, 180);
  }

  @Test
  void givenMaxHousesTotal10AndMultiple11_calculatePresentsPerHouse_returnsTheFirstTenSums() {
    int maxHousesTotal = 10;

    int[] sums =
        ElfDivisorFunctions.calculatePresentsPerHouse(maxHousesTotal, Integer.MAX_VALUE, 11);

    assertThat(sums).containsExactly(11, 33, 44, 77, 66, 132, 88, 165, 143, 198);
  }
}
