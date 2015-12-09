package eu.happycoders.adventofcode2015.day9;

import java.util.ArrayList;
import java.util.List;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>A route through multiple cities keeping track of its total length.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class Route {

  private final List<String> cities = new ArrayList<>();
  private final List<Integer> distances = new ArrayList<>();

  private int totalLength;

  void add(String source, int distance) {
    cities.add(source);
    distances.add(distance);
    totalLength += distance;
  }

  void removeLast() {
    int lastIndex = size() - 1;
    cities.remove(lastIndex);
    Integer removedDistance = distances.remove(lastIndex);
    totalLength -= removedDistance;
  }

  int size() {
    return cities.size();
  }

  String lastCity() {
    int lastIndex = size() - 1;
    return cities.get(lastIndex);
  }

  boolean containsCity(String city) {
    return cities.contains(city);
  }

  int totalLength() {
    return totalLength;
  }

  @Override
  public String toString() {
    return String.join(" -> ", cities) + " = " + totalLength;
  }
}
