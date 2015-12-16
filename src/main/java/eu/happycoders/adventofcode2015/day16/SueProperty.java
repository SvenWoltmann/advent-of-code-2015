package eu.happycoders.adventofcode2015.day16;

import java.util.Objects;

class SueProperty {

  private final String name;
  private final int value;

  SueProperty(String name, int value) {
    this.name = name;
    this.value = value;
  }

  String name() {
    return name;
  }

  int value() {
    return value;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    SueProperty that = (SueProperty) object;
    return value == that.value && name.equals(that.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, value);
  }
}
