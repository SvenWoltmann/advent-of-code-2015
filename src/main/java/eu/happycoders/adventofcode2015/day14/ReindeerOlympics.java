package eu.happycoders.adventofcode2015.day14;

import java.util.List;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>The Reindeer Olympics.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class ReindeerOlympics {

  private final List<Reindeer> allReindeer;

  ReindeerOlympics(List<Reindeer> allReindeer) {
    this.allReindeer = allReindeer;
  }

  int getFarthestDistanceAfterSeconds(int seconds) {
    return allReindeer.stream()
        .mapToInt(reindeer -> reindeer.getDistanceAfterSeconds(seconds))
        .max()
        .orElse(0);
  }

  int getMostPointsAfterSeconds(int totalSeconds) {
    // Simulating a race is O(n * m) where n is the total time and m the number of horses.
    // Calling getDistanceAfterSeconds() after each second would be O(n² * m).
    allReindeer.forEach(Reindeer::startRace);

    for (int second = 1; second <= totalSeconds; second++) {
      int maxDistanceThisSecond = 0;
      for (Reindeer reindeer : allReindeer) {
        reindeer.tick();
        if (reindeer.getDistanceTraveled() > maxDistanceThisSecond) {
          maxDistanceThisSecond = reindeer.getDistanceTraveled();
        }
      }

      awardPointsToFarthestReindeer(maxDistanceThisSecond);
    }

    return allReindeer.stream().mapToInt(Reindeer::getPoints).max().orElse(0);
  }

  private void awardPointsToFarthestReindeer(int maxDistanceThisSecond) {
    for (Reindeer reindeer : allReindeer) {
      if (reindeer.getDistanceTraveled() == maxDistanceThisSecond) {
        reindeer.addOnePoint();
      }
    }
  }
}
