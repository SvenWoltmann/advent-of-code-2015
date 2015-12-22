package eu.happycoders.adventofcode2015.day22;

import java.util.Objects;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>The sum of multiple {@link SpellEffect}s.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class SumOfSpellEffects {

  private final int armor;
  private final int damage;
  private final int newMana;

  SumOfSpellEffects(int armor, int damage, int newMana) {
    this.armor = armor;
    this.damage = damage;
    this.newMana = newMana;
  }

  int armor() {
    return armor;
  }

  int damage() {
    return damage;
  }

  int newMana() {
    return newMana;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    SumOfSpellEffects that = (SumOfSpellEffects) object;
    return armor == that.armor && damage == that.damage && newMana == that.newMana;
  }

  @Override
  public int hashCode() {
    return Objects.hash(armor, damage, newMana);
  }
}
