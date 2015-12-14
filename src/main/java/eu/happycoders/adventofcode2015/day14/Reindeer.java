package eu.happycoders.adventofcode2015.day14;

import java.util.Objects;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>A reindeer with its information.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class Reindeer {

  private final String name;
  private final int airspeed;
  private final int maxFlightDuration;
  private final int restDuration;

  private boolean flying;
  private int remainingTimeInCurrentMode;
  private int distanceTraveled;
  private int points;

  Reindeer(String name, int airspeed, int maxFlightDuration, int restDuration) {
    this.name = name;
    this.airspeed = airspeed;
    this.maxFlightDuration = maxFlightDuration;
    this.restDuration = restDuration;
  }

  int getDistanceAfterSeconds(int seconds) {
    int remainingSeconds = seconds;
    int result = 0;
    while (remainingSeconds > 0) {
      int flightDuration = Math.min(maxFlightDuration, remainingSeconds);
      result += flightDuration * airspeed;
      remainingSeconds -= flightDuration;

      // This can make remainingSeconds negative,
      // but we don't care as we don't need the value afterward.
      remainingSeconds -= restDuration;
    }
    return result;
  }

  void startRace() {
    flying = true;
    remainingTimeInCurrentMode = maxFlightDuration;
    distanceTraveled = 0;
    points = 0;
  }

  void tick() {
    if (flying) {
      distanceTraveled += airspeed;
    }
    remainingTimeInCurrentMode--;
    if (remainingTimeInCurrentMode == 0) {
      flying = !flying;
      remainingTimeInCurrentMode = flying ? maxFlightDuration : restDuration;
    }
  }

  int getDistanceTraveled() {
    return distanceTraveled;
  }

  void addOnePoint() {
    points++;
  }

  int getPoints() {
    return points;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }

    Reindeer that = (Reindeer) object;
    return airspeed == that.airspeed
        && maxFlightDuration == that.maxFlightDuration
        && restDuration == that.restDuration
        && name.equals(that.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, airspeed, maxFlightDuration, restDuration);
  }
}
