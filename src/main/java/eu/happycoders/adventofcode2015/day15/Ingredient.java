package eu.happycoders.adventofcode2015.day15;

import static java.lang.String.format;

import java.util.Objects;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>A type of ingredient for the cookies.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class Ingredient {

  private final String name;
  private final int capacity;
  private final int durability;
  private final int flavor;
  private final int texture;
  private final int calories;

  Ingredient(String name, int capacity, int durability, int flavor, int texture, int calories) {
    this.name = name;
    this.capacity = capacity;
    this.durability = durability;
    this.flavor = flavor;
    this.texture = texture;
    this.calories = calories;
  }

  String name() {
    return name;
  }

  int capacity() {
    return capacity;
  }

  int durability() {
    return durability;
  }

  int flavor() {
    return flavor;
  }

  int texture() {
    return texture;
  }

  int calories() {
    return calories;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }

    Ingredient that = (Ingredient) object;
    return capacity == that.capacity
        && durability == that.durability
        && flavor == that.flavor
        && texture == that.texture
        && calories == that.calories
        && name.equals(that.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, capacity, durability, flavor, texture, calories);
  }

  @Override
  public String toString() {
    return format(
        "%s: capacity %d, durability %d, flavor %d, texture %d, calories %d",
        name, capacity, durability, flavor, texture, calories);
  }
}
