package eu.happycoders.adventofcode2015.day18;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>A position with X and Y coordinates.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
@SuppressWarnings("PMD.ShortVariable") // x and y are OK!
class Position {

  private final int x;
  private final int y;

  Position(int x, int y) {
    this.x = x;
    this.y = y;
  }

  int x() {
    return x;
  }

  int y() {
    return y;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }

    Position position = (Position) object;
    return x == position.x && y == position.y;
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }

  @Override
  public String toString() {
    return x + "," + y;
  }

  List<Position> getNeighbors() {
    List<Position> result = new ArrayList<>();
    result.add(new Position(x, y - 1));
    result.add(new Position(x + 1, y - 1));
    result.add(new Position(x + 1, y));
    result.add(new Position(x + 1, y + 1));
    result.add(new Position(x, y + 1));
    result.add(new Position(x - 1, y + 1));
    result.add(new Position(x - 1, y));
    result.add(new Position(x - 1, y - 1));
    return result;
  }
}
