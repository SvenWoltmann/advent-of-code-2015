package eu.happycoders.adventofcode2015.day22;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>The effect of a {@link Spell}.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class SpellEffect {

  private final int duration;
  private final int armor;
  private final int damage;
  private final int newMana;

  SpellEffect(int duration, int armor, int damage, int newMana) {
    this.duration = duration;
    this.armor = armor;
    this.damage = damage;
    this.newMana = newMana;
  }

  int duration() {
    return duration;
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
}
