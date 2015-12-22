package eu.happycoders.adventofcode2015.day22;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>A specific instance of a spell including the remaining effect time.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class Spell {

  private final SpellType spellType;
  private int timer;

  Spell(SpellType spellType) {
    this.spellType = spellType;
    this.timer = spellType.effect() != null ? spellType().effect().duration() : 0;
  }

  private Spell(SpellType spellType, int timer) {
    this.spellType = spellType;
    this.timer = timer;
  }

  SpellType spellType() {
    return spellType;
  }

  int getTimer() {
    return timer;
  }

  void decreaseTimer() {
    if (timer == 0) {
      return;
    }
    timer--;
  }

  Spell copy() {
    return new Spell(spellType, timer);
  }
}
