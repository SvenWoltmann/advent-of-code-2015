package eu.happycoders.adventofcode2015.day23;

import java.util.Objects;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Abstract base class for instructions changing the value of a register (<code>hlf</code>,
 * <code>tpl</code>, <code>inc</code>).
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
abstract class RegisterModificationInstruction implements Instruction {
  final RegisterName registerName;

  RegisterModificationInstruction(RegisterName registerName) {
    Objects.requireNonNull(registerName);
    this.registerName = registerName;
  }

  RegisterName registerName() {
    return registerName;
  }

  abstract void apply(Register register);

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    RegisterModificationInstruction that = (RegisterModificationInstruction) object;
    return registerName == that.registerName;
  }

  @Override
  public int hashCode() {
    return Objects.hash(registerName);
  }
}
