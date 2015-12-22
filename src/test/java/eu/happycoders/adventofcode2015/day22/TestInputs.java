package eu.happycoders.adventofcode2015.day22;

class TestInputs {

  static final String TEST_INPUT =
      "Hit Points: 13\n" //
          + "Damage: 8";

  static final String TEST_INPUT_MORE_HITPOINTS =
      "Hit Points: 40\n" //
          + "Damage: 8";

  static final PlayerStats TEST_BOSS_STATS = new PlayerStats(13, 8);

  static final PlayerStats TEST_BOSS_WITH_14_HIT_POINTS = new PlayerStats(14, 8);
}
