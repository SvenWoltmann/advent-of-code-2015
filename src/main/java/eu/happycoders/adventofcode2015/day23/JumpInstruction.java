package eu.happycoders.adventofcode2015.day23;

import java.util.Objects;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p><code>jmp offset</code> is a <b>jump</b>; it continues with the instruction offset away
 * <b>relative to itself</b>.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class JumpInstruction implements Instruction {

  private final int offset;

  JumpInstruction(int offset) {
    this.offset = offset;
  }

  int offset() {
    return offset;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    JumpInstruction that = (JumpInstruction) object;
    return offset == that.offset;
  }

  @Override
  public int hashCode() {
    return Objects.hash(offset);
  }

  @Override
  public String toString() {
    return "jmp " + offset;
  }
}
