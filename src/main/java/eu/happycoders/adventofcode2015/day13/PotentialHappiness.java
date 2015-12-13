package eu.happycoders.adventofcode2015.day13;

import static java.lang.String.format;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Happiness units for a person seated next to a specific neighbor.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class PotentialHappiness {

  private final PersonAndNeighbor personAndNeighbor;
  private final int happinessUnits;

  PotentialHappiness(PersonAndNeighbor personAndNeighbor, int happinessUnits) {
    this.personAndNeighbor = personAndNeighbor;
    this.happinessUnits = happinessUnits;
  }

  PersonAndNeighbor personAndNeighbor() {
    return personAndNeighbor;
  }

  int happinessUnits() {
    return happinessUnits;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }

    PotentialHappiness that = (PotentialHappiness) object;
    return happinessUnits == that.happinessUnits
        && personAndNeighbor.equals(that.personAndNeighbor);
  }

  @Override
  public int hashCode() {
    int result = personAndNeighbor.hashCode();
    result = 31 * result + happinessUnits;
    return result;
  }

  @Override
  public String toString() {
    if (happinessUnits >= 0) {
      return format(
          "%s would gain %d happiness units by sitting next to %s.",
          personAndNeighbor.person(), happinessUnits, personAndNeighbor.neighbor());
    } else {
      return format(
          "%s would lose %d happiness units by sitting next to %s.",
          personAndNeighbor.person(), -happinessUnits, personAndNeighbor.neighbor());
    }
  }
}
