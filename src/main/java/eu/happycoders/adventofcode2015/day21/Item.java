package eu.happycoders.adventofcode2015.day21;

import java.util.Objects;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>An item that can be bought in the {@link Shop}.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class Item {

  private final String name;
  private final int cost;
  private final int damage;
  private final int armor;

  Item(String name, int cost, int damage, int armor) {
    this.name = name;
    this.cost = cost;
    this.damage = damage;
    this.armor = armor;
  }

  String name() {
    return name;
  }

  int cost() {
    return cost;
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
    Item that = (Item) object;
    return cost == that.cost
        && damage == that.damage
        && armor == that.armor
        && name.equals(that.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, cost, damage, armor);
  }

  @Override
  public String toString() {
    return name;
  }
}
