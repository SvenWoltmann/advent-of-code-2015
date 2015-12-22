package eu.happycoders.adventofcode2015.day22;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>A type of spell to be cast.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
enum SpellType {
  MAGIC_MISSILE("Magic Missile", 53, 4, 0, null),
  DRAIN("Drain", 73, 2, 2, null),
  SHIELD("Shield", 113, 0, 0, new SpellEffect(6, 7, 0, 0)),
  POISON("Poison", 173, 0, 0, new SpellEffect(6, 0, 3, 0)),
  RECHARGE("Recharge", 229, 0, 0, new SpellEffect(5, 0, 0, 101));

  private final String name;
  private final int cost;
  private final int instantDamage;
  private final int instantHeal;
  private final SpellEffect effect;

  SpellType(String name, int cost, int instantDamage, int instantHeal, SpellEffect effect) {
    this.name = name;
    this.cost = cost;
    this.instantDamage = instantDamage;
    this.instantHeal = instantHeal;
    this.effect = effect;
  }

  int cost() {
    return cost;
  }

  int instantDamage() {
    return instantDamage;
  }

  int instantHeal() {
    return instantHeal;
  }

  SpellEffect effect() {
    return effect;
  }

  @Override
  public String toString() {
    return name;
  }
}
