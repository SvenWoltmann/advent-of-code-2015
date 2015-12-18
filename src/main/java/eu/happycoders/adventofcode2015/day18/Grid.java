package eu.happycoders.adventofcode2015.day18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>A grid of lights.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class Grid {

  private boolean[][] litLights;
  private final int height;
  private final int width;
  private boolean cornerLightsAlwaysOn;

  Grid(boolean[][] litLights) {
    this.height = litLights.length;
    this.width = litLights[0].length;
    this.litLights = new boolean[height][];
    for (int y = 0; y < height; y++) {
      this.litLights[y] = Arrays.copyOf(litLights[y], width);
    }
  }

  void setCornerLightsAlwaysOn(boolean cornerLightsAlwaysOn) {
    this.cornerLightsAlwaysOn = cornerLightsAlwaysOn;
    litLights[0][0] = true;
    litLights[0][width - 1] = true;
    litLights[height - 1][0] = true;
    litLights[height - 1][width - 1] = true;
  }

  void nextSteps(int steps) {
    for (int i = 0; i < steps; i++) {
      nextStep();
    }
  }

  void nextStep() {
    // A light which is on stays on when 2 or 3 neighbors are on, and turns off otherwise.
    // A light which is off turns on if exactly 3 neighbors are on, and stays off otherwise.

    // The grid is small and has a lot of lights turned on, so it makes sense to check all
    // coordinates. For a grid with a small number of lights turned on, it would make more sense to
    // keep track of those only and apply the rules starting from the lit lights.
    boolean[][] nextStep = new boolean[height][width];

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        nextStep[y][x] = calculateNextStep(new Position(x, y));
      }
    }

    litLights = nextStep;
  }

  private boolean calculateNextStep(Position position) {
    if (cornerLightsAlwaysOn && isCorner(position)) {
      return true;
    }

    int litNeighbors = countLitNeighbors(position);
    if (litLights[position.y()][position.x()]) {
      return litNeighbors == 2 || litNeighbors == 3;
    } else {
      return litNeighbors == 3;
    }
  }

  private boolean isCorner(Position position) {
    return position.x() == 0 && position.y() == 0
        || position.x() == 0 && position.y() == height - 1
        || position.x() == width - 1 && position.y() == 0
        || position.x() == width - 1 && position.y() == height - 1;
  }

  private int countLitNeighbors(Position position) {
    List<Position> neighbors = position.getNeighbors();
    int result = 0;
    for (Position neighbor : neighbors) {
      if (isLit(neighbor)) {
        result++;
      }
    }
    return result;
  }

  private boolean isLit(Position position) {
    return position.x() >= 0
        && position.x() < width
        && position.y() >= 0
        && position.y() < height
        && litLights[position.y()][position.x()];
  }

  List<Position> getLitLights() {
    List<Position> result = new ArrayList<>();

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        if (litLights[y][x]) {
          result.add(new Position(x, y));
        }
      }
    }

    return result;
  }

  int countLitLights() {
    int result = 0;

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        if (litLights[y][x]) {
          result++;
        }
      }
    }

    return result;
  }
}
