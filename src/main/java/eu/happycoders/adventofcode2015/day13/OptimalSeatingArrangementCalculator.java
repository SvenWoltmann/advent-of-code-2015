package eu.happycoders.adventofcode2015.day13;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>The optimal seating arrangement calculator.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class OptimalSeatingArrangementCalculator {

  private final Map<PersonAndNeighbor, Integer> personAndNeighborToHappinessUnits;
  private final Set<String> persons;

  OptimalSeatingArrangementCalculator(List<PotentialHappiness> potentialHappinesses) {
    this.personAndNeighborToHappinessUnits =
        potentialHappinesses.stream()
            .collect(
                Collectors.toMap(
                    PotentialHappiness::personAndNeighbor, PotentialHappiness::happinessUnits));
    this.persons =
        potentialHappinesses.stream()
            .map(potentialHappiness -> potentialHappiness.personAndNeighbor().person())
            .collect(Collectors.toSet());
  }

  int calculateOptimalSeatingArrangement() {
    AtomicInteger maxTotalChangeInHappiness = new AtomicInteger(Integer.MIN_VALUE);
    SittingOrder sittingOrder = new SittingOrder();
    tryAllPersonsNotYetOnTheTableRecursively(sittingOrder, maxTotalChangeInHappiness);
    return maxTotalChangeInHappiness.get();
  }

  private void tryAllPersonsNotYetOnTheTableRecursively(
      SittingOrder sittingOrder, AtomicInteger maxTotalChangeInHappiness) {
    if (sittingOrder.size() == persons.size()) {
      int totalChangeInHappiness =
          sittingOrder.calculateTotalChangeInHappiness(personAndNeighborToHappinessUnits);
      if (totalChangeInHappiness > maxTotalChangeInHappiness.get()) {
        maxTotalChangeInHappiness.set(totalChangeInHappiness);
      }
      return;
    }

    for (String person : persons) {
      if (!sittingOrder.containsPerson(person)) {
        sittingOrder.add(person);
        tryAllPersonsNotYetOnTheTableRecursively(sittingOrder, maxTotalChangeInHappiness);
        sittingOrder.removeLast();
      }
    }
  }
}
