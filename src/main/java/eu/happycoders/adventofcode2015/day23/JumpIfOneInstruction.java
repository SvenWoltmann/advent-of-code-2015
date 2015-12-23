package eu.happycoders.adventofcode2015.day23;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p><code>jio r, offset</code> is like <code>jmp</code>, but only jumps if register <code>r</code>
 * is <b>one</b> ("jump if one", not odd).
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class JumpIfOneInstruction extends ConditionalJumpInstruction {

  JumpIfOneInstruction(RegisterName registerName, int offset) {
    super(registerName, offset);
  }

  @Override
  boolean test(Register register) {
    return register.getValue() == 1;
  }

  @Override
  public String toString() {
    return "jio " + registerName + ", " + offset;
  }
}
