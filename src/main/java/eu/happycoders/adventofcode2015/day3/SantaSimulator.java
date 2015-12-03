package eu.happycoders.adventofcode2015.day3;

import java.util.HashSet;
import java.util.Set;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Simulator going into directions and delivering presents.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class SantaSimulator {

  private final Set<Location> deliveredLocations = new HashSet<>();
  private Location location = new Location(0, 0);

  SantaSimulator() {
    deliveredLocations.add(location);
  }

  void goTo(Direction direction) {
    location = location.at(direction);
    deliveredLocations.add(location);
  }

  public Set<Location> getDeliveredLocations() {
    return deliveredLocations;
  }
}
