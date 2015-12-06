package eu.happycoders.adventofcode2015.day6;

import java.util.Objects;

class Instruction {

  private final Command command;
  private final Position start;
  private final Position end;

  Instruction(Command command, Position start, Position end) {
    this.command = command;
    this.start = start;
    this.end = end;
  }

  Command command() {
    return command;
  }

  Position start() {
    return start;
  }

  Position end() {
    return end;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }

    Instruction that = (Instruction) object;
    return command == that.command
        && Objects.equals(start, that.start)
        && Objects.equals(end, that.end);
  }

  @Override
  public int hashCode() {
    int result = command != null ? command.hashCode() : 0;
    result = 31 * result + (start != null ? start.hashCode() : 0);
    result = 31 * result + (end != null ? end.hashCode() : 0);
    return result;
  }
}
