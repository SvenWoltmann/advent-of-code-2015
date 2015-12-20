package eu.happycoders.adventofcode2015.day20;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ElfDivisorFunctionsTest {

  @Test
  void givenMinimumPresents100_findLowestHouseNoForSumOfPresents_returns6() {
    int minPresents = 100;

    int lowestN =
        ElfDivisorFunctions.findLowestHouseNoForSumOfPresents(minPresents, Integer.MAX_VALUE, 10);

    assertThat(lowestN).isEqualTo(6);
  }

  @Test
  void givenMinimumPresents1000_findLowestHouseNoForSumOfPresents_returns48() {
    int minPresents = 1_000;

    int lowestN =
        ElfDivisorFunctions.findLowestHouseNoForSumOfPresents(minPresents, Integer.MAX_VALUE, 10);

    assertThat(lowestN).isEqualTo(48);
  }

  @Test
  void givenMinimumPresents10000_findLowestHouseNoForSumOfPresents_returns360() {
    int minPresents = 10_000;

    int lowestN =
        ElfDivisorFunctions.findLowestHouseNoForSumOfPresents(minPresents, Integer.MAX_VALUE, 10);

    assertThat(lowestN).isEqualTo(360);
  }

  @Test
  void
      givenMinimumPresents100AndMaxHousesPerElf5AndElfMultiple20_findLowestHouseNoForSumOfPresents_returns4() {
    int minPresents = 100;

    int lowestN = ElfDivisorFunctions.findLowestHouseNoForSumOfPresents(minPresents, 5, 20);

    assertThat(lowestN).isEqualTo(4);
  }

  @Test
  void
      givenMinimumPresents1000AndMaxHousesPerElf5AndElfMultiple20_findLowestHouseNoForSumOfPresents_returns48() {
    int minPresents = 1_000;

    int lowestN = ElfDivisorFunctions.findLowestHouseNoForSumOfPresents(minPresents, 5, 20);

    assertThat(lowestN).isEqualTo(24);
  }

  @Test
  void
      givenMinimumPresents10000AndMaxHousesPerElf5AndElfMultiple20_findLowestHouseNoForSumOfPresents_returns360() {
    int minPresents = 10_000;

    int lowestN = ElfDivisorFunctions.findLowestHouseNoForSumOfPresents(minPresents, 5, 20);

    assertThat(lowestN).isEqualTo(240);
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
