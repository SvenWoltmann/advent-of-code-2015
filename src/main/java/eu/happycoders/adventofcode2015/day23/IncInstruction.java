package eu.happycoders.adventofcode2015.day23;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p><code>inc r</code> <b>increments</b> register <code>r</code>, adding <code>1</code> to it,
 * then continues with the next instruction.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class IncInstruction extends RegisterModificationInstruction {

  IncInstruction(RegisterName registerName) {
    super(registerName);
  }

  @Override
  void apply(Register register) {
    register.setValue(register.getValue() + 1);
  }

  @Override
  public String toString() {
    return "inc " + registerName;
  }
}
