package eu.happycoders.adventofcode2015.day13;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>A person and its neighbor.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class PersonAndNeighbor {

  private final String person;
  private final String neighbor;

  PersonAndNeighbor(String person, String neighbor) {
    this.person = person;
    this.neighbor = neighbor;
  }

  String person() {
    return person;
  }

  String neighbor() {
    return neighbor;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }

    PersonAndNeighbor that = (PersonAndNeighbor) object;
    return person.equals(that.person) && neighbor.equals(that.neighbor);
  }

  @Override
  public int hashCode() {
    int result = person.hashCode();
    result = 31 * result + neighbor.hashCode();
    return result;
  }
}
