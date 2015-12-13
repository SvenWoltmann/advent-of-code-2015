package eu.happycoders.adventofcode2015.day13;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>The sitting order.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class SittingOrder {

  private final List<String> persons = new ArrayList<>();

  void add(String person) {
    persons.add(person);
  }

  void removeLast() {
    int lastIndex = size() - 1;
    persons.remove(lastIndex);
  }

  int size() {
    return persons.size();
  }

  boolean containsPerson(String person) {
    return persons.contains(person);
  }

  @SuppressWarnings("PMD.ForLoopCanBeForeach") // False positive
  int calculateTotalChangeInHappiness(
      Map<PersonAndNeighbor, Integer> personAndNeighborToHappinessUnits) {
    int result = 0;
    for (int i = 0; i < persons.size(); i++) {
      String person = persons.get(i);
      String neighbor = persons.get(i < persons.size() - 1 ? i + 1 : 0);
      result += personAndNeighborToHappinessUnits.get(new PersonAndNeighbor(person, neighbor));
      result += personAndNeighborToHappinessUnits.get(new PersonAndNeighbor(neighbor, person));
    }
    return result;
  }

  @Override
  public String toString() {
    return String.join(" -> ", persons);
  }
}
