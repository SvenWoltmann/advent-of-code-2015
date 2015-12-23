package eu.happycoders.adventofcode2015.day23;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>A register with its value.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class Register {
  private int value;

  int getValue() {
    return value;
  }

  void setValue(int value) {
    this.value = value;
  }
}
