package eu.happycoders.adventofcode2015.day16;

import java.util.List;
import java.util.Objects;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>A specific Sue with her number and properties.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class Sue {

  private final int number;

  private final List<SueProperty> properties;

  Sue(int number, List<SueProperty> properties) {
    this.number = number;
    this.properties = properties;
  }

  int number() {
    return number;
  }

  List<SueProperty> properties() {
    return properties;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    Sue that = (Sue) object;
    return number == that.number && properties.equals(that.properties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(number, properties);
  }
}
