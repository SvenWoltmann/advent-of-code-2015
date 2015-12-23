package eu.happycoders.adventofcode2015.day23;

import java.util.Objects;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Abstract base class for a conditional jump instruction (<code>jie</code>, <code>jio</code>).
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
abstract class ConditionalJumpInstruction implements Instruction {

  final RegisterName registerName;
  final int offset;

  ConditionalJumpInstruction(RegisterName registerName, int offset) {
    this.registerName = registerName;
    this.offset = offset;
  }

  RegisterName registerName() {
    return registerName;
  }

  int offset() {
    return offset;
  }

  abstract boolean test(Register register);

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    ConditionalJumpInstruction that = (ConditionalJumpInstruction) object;
    return offset == that.offset && registerName == that.registerName;
  }

  @Override
  public int hashCode() {
    return Objects.hash(registerName, offset);
  }
}
