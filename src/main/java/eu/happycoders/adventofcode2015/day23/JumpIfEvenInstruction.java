package eu.happycoders.adventofcode2015.day23;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p><code>jie r, offset</code> is like <code>jmp</code>, but only jumps if register <code>r</code>
 * is <b>even</b> ("jump if even").
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class JumpIfEvenInstruction extends ConditionalJumpInstruction {

  JumpIfEvenInstruction(RegisterName registerName, int offset) {
    super(registerName, offset);
  }

  @Override
  boolean test(Register register) {
    return register.getValue() % 2 == 0;
  }

  @Override
  public String toString() {
    return "jie " + registerName + ", " + offset;
  }
}
