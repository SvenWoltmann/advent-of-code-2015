package eu.happycoders.adventofcode2015.day22;

import static eu.happycoders.adventofcode2015.day22.SpellType.DRAIN;
import static eu.happycoders.adventofcode2015.day22.SpellType.MAGIC_MISSILE;
import static eu.happycoders.adventofcode2015.day22.SpellType.POISON;
import static eu.happycoders.adventofcode2015.day22.SpellType.RECHARGE;
import static eu.happycoders.adventofcode2015.day22.SpellType.SHIELD;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class SequenceOfSpellsTest {

  @Test
  void
      givenAnEmptySequenceOfSpells_whenDecreasingTimersAndCastingNewSpellsAccordingToTheFirstExample_totalDamageAndRemainingTimersAreCalculatedCorrectly() {
    SequenceOfSpells spells = new SequenceOfSpells();

    // Player turn
    assertThat(spells.getSumOfActiveSpellEffects()).isEqualTo(new SumOfSpellEffects(0, 0, 0));

    spells.decreaseTimers();
    Spell poisonSpell = spells.cast(POISON);
    assertThat(poisonSpell.getTimer()).isEqualTo(6);

    // Boss turn
    assertThat(spells.getSumOfActiveSpellEffects()).isEqualTo(new SumOfSpellEffects(0, 3, 0));

    spells.decreaseTimers();
    assertThat(poisonSpell.getTimer()).isEqualTo(5);

    // Player turn
    assertThat(spells.getSumOfActiveSpellEffects()).isEqualTo(new SumOfSpellEffects(0, 3, 0));

    spells.decreaseTimers();
    Spell magicMissileSpellType = spells.cast(MAGIC_MISSILE);
    assertThat(poisonSpell.getTimer()).isEqualTo(4);
    assertThat(magicMissileSpellType.getTimer()).isZero();

    // Boss turn
    assertThat(spells.getSumOfActiveSpellEffects()).isEqualTo(new SumOfSpellEffects(0, 3, 0));

    spells.decreaseTimers();
    assertThat(poisonSpell.getTimer()).isEqualTo(3);
    assertThat(magicMissileSpellType.getTimer()).isZero();
  }

  @Test
  void
      givenAnEmptySequenceOfSpells_whenDecreasingTimersAndCastingNewSpellsAccordingToTheSecondExample_totalDamageAndRemainingTimersAreCalculatedCorrectly() {
    SequenceOfSpells spells = new SequenceOfSpells();

    // Player turn
    assertThat(spells.getSumOfActiveSpellEffects()).isEqualTo(new SumOfSpellEffects(0, 0, 0));

    spells.decreaseTimers();
    Spell rechargeSpell = spells.cast(RECHARGE);
    assertThat(rechargeSpell.getTimer()).isEqualTo(5);

    // Boss turn
    assertThat(spells.getSumOfActiveSpellEffects()).isEqualTo(new SumOfSpellEffects(0, 0, 101));

    spells.decreaseTimers();
    assertThat(rechargeSpell.getTimer()).isEqualTo(4);

    // Player turn
    assertThat(spells.getSumOfActiveSpellEffects()).isEqualTo(new SumOfSpellEffects(0, 0, 101));

    spells.decreaseTimers();
    Spell shieldSpell = spells.cast(SHIELD);
    assertThat(rechargeSpell.getTimer()).isEqualTo(3);
    assertThat(shieldSpell.getTimer()).isEqualTo(6);

    // Boss turn
    assertThat(spells.getSumOfActiveSpellEffects()).isEqualTo(new SumOfSpellEffects(7, 0, 101));

    spells.decreaseTimers();
    assertThat(rechargeSpell.getTimer()).isEqualTo(2);
    assertThat(shieldSpell.getTimer()).isEqualTo(5);

    // Player turn
    assertThat(spells.getSumOfActiveSpellEffects()).isEqualTo(new SumOfSpellEffects(7, 0, 101));

    spells.decreaseTimers();
    Spell drainSpell = spells.cast(DRAIN);
    assertThat(rechargeSpell.getTimer()).isEqualTo(1);
    assertThat(shieldSpell.getTimer()).isEqualTo(4);
    assertThat(drainSpell.getTimer()).isZero();

    // Boss turn
    assertThat(spells.getSumOfActiveSpellEffects()).isEqualTo(new SumOfSpellEffects(7, 0, 101));

    spells.decreaseTimers();
    assertThat(rechargeSpell.getTimer()).isZero();
    assertThat(shieldSpell.getTimer()).isEqualTo(3);

    // Player turn
    assertThat(spells.getSumOfActiveSpellEffects()).isEqualTo(new SumOfSpellEffects(7, 0, 0));

    spells.decreaseTimers();
    Spell poisonSpell = spells.cast(POISON);
    assertThat(rechargeSpell.getTimer()).isZero();
    assertThat(shieldSpell.getTimer()).isEqualTo(2);
    assertThat(drainSpell.getTimer()).isZero();
    assertThat(poisonSpell.getTimer()).isEqualTo(6);

    // Boss turn
    assertThat(spells.getSumOfActiveSpellEffects()).isEqualTo(new SumOfSpellEffects(7, 3, 0));

    spells.decreaseTimers();
    assertThat(rechargeSpell.getTimer()).isZero();
    assertThat(shieldSpell.getTimer()).isEqualTo(1);
    assertThat(drainSpell.getTimer()).isZero();
    assertThat(poisonSpell.getTimer()).isEqualTo(5);

    // Player turn
    assertThat(spells.getSumOfActiveSpellEffects()).isEqualTo(new SumOfSpellEffects(7, 3, 0));

    spells.decreaseTimers();
    Spell magicMissileSpell = spells.cast(MAGIC_MISSILE);
    assertThat(rechargeSpell.getTimer()).isZero();
    assertThat(shieldSpell.getTimer()).isZero();
    assertThat(drainSpell.getTimer()).isZero();
    assertThat(poisonSpell.getTimer()).isEqualTo(4);
    assertThat(magicMissileSpell.getTimer()).isZero();

    // Boss turn
    assertThat(spells.getSumOfActiveSpellEffects()).isEqualTo(new SumOfSpellEffects(0, 3, 0));

    spells.decreaseTimers();
    assertThat(rechargeSpell.getTimer()).isZero();
    assertThat(shieldSpell.getTimer()).isZero();
    assertThat(drainSpell.getTimer()).isZero();
    assertThat(poisonSpell.getTimer()).isEqualTo(3);
  }

  @ParameterizedTest
  @ValueSource(ints = {0, 1, 2, 3, 4})
  void givenASequenceWithAnActiveSpell_whenCastingTheSameSpell_throwsAnException(
      int numberOfTimesToDecreaseTimer) {
    SequenceOfSpells spells = new SequenceOfSpells();
    spells.cast(RECHARGE);
    for (int i = 0; i < numberOfTimesToDecreaseTimer; i++) {
      spells.decreaseTimers();
    }
    assertThatIllegalArgumentException().isThrownBy(() -> spells.cast(RECHARGE));
  }

  @Test
  void givenASequenceWithAnActiveSpell_whenCastingTheSameSpellAfterItExpired_throwsNoException() {
    SequenceOfSpells spells = new SequenceOfSpells();
    spells.cast(RECHARGE);
    for (int i = 0; i < 5; i++) {
      spells.decreaseTimers();
    }
    assertThatNoException().isThrownBy(() -> spells.cast(RECHARGE));
  }
}
