package eu.happycoders.adventofcode2015.day9;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>A path from one city to another including its distance.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class Path {

  private final String source;
  private final String destination;
  private final int distance;

  Path(String source, String destination, int distance) {
    this.source = source;
    this.destination = destination;
    this.distance = distance;
  }

  String source() {
    return source;
  }

  String destination() {
    return destination;
  }

  int distance() {
    return distance;
  }

  Path reverse() {
    return new Path(destination, source, distance);
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }

    Path that = (Path) object;
    return distance == that.distance
        && source.equals(that.source)
        && destination.equals(that.destination);
  }

  @Override
  public int hashCode() {
    int result = source.hashCode();
    result = 31 * result + destination.hashCode();
    result = 31 * result + distance;
    return result;
  }
}
