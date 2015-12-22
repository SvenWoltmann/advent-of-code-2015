package eu.happycoders.adventofcode2015.day22;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>A sequence of {@link Spell}s.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class SequenceOfSpells {

  private final List<Spell> spells;
  private final List<Spell> activeSpells;
  private int totalCost;

  SequenceOfSpells() {
    spells = new ArrayList<>();
    activeSpells = new ArrayList<>();
  }

  private SequenceOfSpells(List<Spell> spells, List<Spell> activeSpells, int totalCost) {
    this.spells = spells;
    this.activeSpells = activeSpells;
    this.totalCost = totalCost;
  }

  int getTotalCost() {
    return totalCost;
  }

  List<SpellType> getSpellTypes() {
    return spells.stream().map(Spell::spellType).collect(Collectors.toList());
  }

  Spell cast(SpellType spellType) {
    if (activeSpells.stream().anyMatch(spell -> spell.spellType() == spellType)) {
      throw new IllegalArgumentException("A " + spellType + " spell is still active");
    }

    Spell spell = new Spell(spellType);
    spells.add(spell);
    if (spellType.effect() != null) {
      activeSpells.add(spell);
    }

    totalCost += spellType.cost();

    return spell;
  }

  SumOfSpellEffects getSumOfActiveSpellEffects() {
    int totalArmor = 0;
    int totalDamage = 0;
    int totalNewMana = 0;

    for (Spell spell : activeSpells) {
      if (spell.getTimer() <= 0) {
        throw new AssertionError("Spell should not be in the active list");
      }
      SpellEffect effect = spell.spellType().effect();
      totalArmor += effect.armor();
      totalDamage += effect.damage();
      totalNewMana += effect.newMana();
    }

    return new SumOfSpellEffects(totalArmor, totalDamage, totalNewMana);
  }

  void decreaseTimers() {
    for (Spell spell : spells) {
      spell.decreaseTimer();
      if (spell.getTimer() == 0) {
        activeSpells.remove(spell);
      }
    }
  }

  boolean isNotActiveAfterDecreasingTheTimer(SpellType spellType) {
    for (Spell spell : spells) {
      if (spell.spellType() == spellType && spell.getTimer() > 1) {
        return false;
      }
    }
    return true;
  }

  SequenceOfSpells deepCopy() {
    List<Spell> spellsCopy = new ArrayList<>();
    List<Spell> activeSpellsCopy = new ArrayList<>();
    for (Spell spell : spells) {
      Spell spellCopy = spell.copy();
      spellsCopy.add(spellCopy);
      if (spell.getTimer() > 0) {
        activeSpellsCopy.add(spellCopy);
      }
    }
    return new SequenceOfSpells(spellsCopy, activeSpellsCopy, totalCost);
  }
}
