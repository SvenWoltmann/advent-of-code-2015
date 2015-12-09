package eu.happycoders.adventofcode2015.day9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Solver for the traveling salesman problem.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class TravelingSalesmanProblemSolver {

  private final Map<String, List<Path>> sourceToPaths;
  private final int numberOfCities;

  private int lengthOfShortestRoute = Integer.MAX_VALUE;
  private int lengthOfLongestRoute = Integer.MIN_VALUE;

  TravelingSalesmanProblemSolver(List<Path> paths) {
    sourceToPaths = new HashMap<>();
    for (Path path : paths) {
      sourceToPaths.computeIfAbsent(path.source(), ignore -> new ArrayList<>()).add(path);
      sourceToPaths
          .computeIfAbsent(path.destination(), ignore -> new ArrayList<>())
          .add(path.reverse());
    }

    numberOfCities = sourceToPaths.size();
  }

  void analyzeAllRoutes() {
    Route route = new Route();

    for (String source : sourceToPaths.keySet()) {
      route.add(source, 0);
      tryAllNextStopsRecursively(route);
      route.removeLast();
    }
  }

  private void tryAllNextStopsRecursively(Route route) {
    if (route.size() == numberOfCities) {
      checkRoute(route);
      return;
    }

    String source = route.lastCity();
    List<Path> paths = sourceToPaths.get(source);

    for (Path path : paths) {
      String destination = path.destination();
      if (!route.containsCity(destination)) {
        route.add(destination, path.distance());
        tryAllNextStopsRecursively(route);
        route.removeLast();
      }
    }
  }

  private void checkRoute(Route route) {
    lengthOfShortestRoute = Math.min(lengthOfShortestRoute, route.totalLength());
    lengthOfLongestRoute = Math.max(lengthOfLongestRoute, route.totalLength());
  }

  int getLengthOfShortestRoute() {
    return lengthOfShortestRoute;
  }

  int getLengthOfLongestRoute() {
    return lengthOfLongestRoute;
  }
}
