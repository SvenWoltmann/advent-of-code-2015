package eu.happycoders.adventofcode2015.day3;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>The direction Santa can go (north, south, east, west).
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
enum Direction {
  NORTH('^'),
  SOUTH('v'),
  EAST('>'),
  WEST('<');

  private final char symbol;

  Direction(char symbol) {
    this.symbol = symbol;
  }

  static Direction of(char symbol) {
    for (Direction value : Direction.values()) {
      if (value.symbol == symbol) {
        return value;
      }
    }
    throw new IllegalArgumentException("Unknown symbol: " + symbol);
  }

  @Override
  public String toString() {
    return String.valueOf(symbol);
  }
}
