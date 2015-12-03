package eu.happycoders.adventofcode2015.day3;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>A location of a house Santa is delivering presents to.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
@SuppressWarnings("PMD.ShortVariable") // x and y are OK!
class Location {

  private final int x;
  private final int y;

  Location(int x, int y) {
    this.x = x;
    this.y = y;
  }

  Location at(Direction direction) {
    switch (direction) {
      case NORTH:
        return new Location(x, y - 1);

      case SOUTH:
        return new Location(x, y + 1);

      case EAST:
        return new Location(x + 1, y);

      case WEST:
        return new Location(x - 1, y);

      default:
        throw new IllegalArgumentException();
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Location that = (Location) o;
    return x == that.x && y == that.y;
  }

  @Override
  public int hashCode() {
    int result = x;
    result = 31 * result + y;
    return result;
  }
}
