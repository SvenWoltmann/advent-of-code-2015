package eu.happycoders.adventofcode2015.day21;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>A set of {@link Item}s used by the player.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class ItemSet {

  private final Item weapon; // exactly 1
  private final Item armor; // 0 or 1
  private final List<Item> rings; // 0, 1, or 2

  private final int totalDamage;
  private final int totalArmor;
  private final int totalCost;

  ItemSet(Item weapon, Item armor, List<Item> rings) {
    Objects.requireNonNull(weapon, "weapon");
    Objects.requireNonNull(rings, "rings");
    if (rings.size() > 2) {
      throw new IllegalArgumentException("Too many rings (max = 2)");
    }

    this.weapon = weapon;
    this.armor = armor;
    this.rings = rings;

    // Pre-calculate as we need this for sorting
    List<Item> allItems = getAllItems();
    this.totalDamage = allItems.stream().mapToInt(Item::damage).sum();
    this.totalArmor = allItems.stream().mapToInt(Item::armor).sum();
    this.totalCost = allItems.stream().mapToInt(Item::cost).sum();
  }

  private List<Item> getAllItems() {
    List<Item> result = new ArrayList<>();
    result.add(weapon);
    if (armor != null) {
      result.add(armor);
    }
    result.addAll(rings);
    return result;
  }

  int getTotalDamage() {
    return totalDamage;
  }

  int getTotalArmor() {
    return totalArmor;
  }

  int getTotalCost() {
    return totalCost;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    ItemSet that = (ItemSet) object;
    return weapon.equals(that.weapon)
        && Objects.equals(armor, that.armor)
        && rings.equals(that.rings);
  }

  @Override
  public int hashCode() {
    return Objects.hash(weapon, armor, rings);
  }

  @Override
  public String toString() {
    return "Weapon: "
        + weapon
        + ", Armor: "
        + (armor != null ? armor : "-")
        + ", Rings: "
        + rings
        + ", Cost: "
        + totalCost;
  }
}
