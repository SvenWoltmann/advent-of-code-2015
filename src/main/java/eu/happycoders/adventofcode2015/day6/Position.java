package eu.happycoders.adventofcode2015.day6;

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

    Position that = (Position) object;
    return x == that.x && y == that.y;
  }

  @Override
  public int hashCode() {
    int result = x;
    result = 31 * result + y;
    return result;
  }
}
