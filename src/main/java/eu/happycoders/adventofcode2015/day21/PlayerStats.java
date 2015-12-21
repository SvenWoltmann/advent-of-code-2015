package eu.happycoders.adventofcode2015.day21;

import java.util.Objects;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>A player's stats (hit points, damage, armor).
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class PlayerStats {

  private final int hitPoints;
  private final int damage;
  private final int armor;

  PlayerStats(int hitPoints, int damage, int armor) {
    this.hitPoints = hitPoints;
    this.damage = damage;
    this.armor = armor;
  }

  PlayerStats(int hitPoints, ItemSet itemSet) {
    this.hitPoints = hitPoints;
    this.damage = itemSet.getTotalDamage();
    this.armor = itemSet.getTotalArmor();
  }

  int hitPoints() {
    return hitPoints;
  }

  int damage() {
    return damage;
  }

  int armor() {
    return armor;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    PlayerStats that = (PlayerStats) object;
    return hitPoints == that.hitPoints && damage == that.damage && armor == that.armor;
  }

  @Override
  public int hashCode() {
    return Objects.hash(hitPoints, damage, armor);
  }
}
