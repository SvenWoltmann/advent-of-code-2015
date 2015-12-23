package eu.happycoders.adventofcode2015.day23;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p><code>hlf r</code> sets register <code>r</code> to <b>half</b> its current value, then
 * continues with the next instruction.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class HalfInstruction extends RegisterModificationInstruction {

  HalfInstruction(RegisterName registerName) {
    super(registerName);
  }

  @Override
  void apply(Register register) {
    register.setValue(register.getValue() / 2);
  }

  @Override
  public String toString() {
    return "hlf " + registerName;
  }
}
