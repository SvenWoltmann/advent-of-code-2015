package eu.happycoders.adventofcode2015.day1;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Simulator executing instructions.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class SantaSimulator {

  private final Instructions instructions;
  private int floor;

  SantaSimulator(Instructions instructions) {
    this.instructions = instructions;
  }

  boolean hasNextInstruction() {
    return instructions.hasNext();
  }

  void executeNextInstruction() {
    Direction direction = instructions.next();
    if (direction == Direction.UP) {
      floor++;
    } else {
      floor--;
    }
  }

  int getFloor() {
    return floor;
  }
}
