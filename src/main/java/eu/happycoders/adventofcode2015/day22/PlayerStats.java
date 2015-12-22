package eu.happycoders.adventofcode2015.day22;

import java.util.Objects;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>A player's stats (hit points and damage).
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class PlayerStats {

  private final int hitPoints;
  private final int damage;

  PlayerStats(int hitPoints, int damage) {
    this.hitPoints = hitPoints;
    this.damage = damage;
  }

  int hitPoints() {
    return hitPoints;
  }

  int damage() {
    return damage;
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
    return hitPoints == that.hitPoints && damage == that.damage;
  }

  @Override
  public int hashCode() {
    return Objects.hash(hitPoints, damage);
  }
}
