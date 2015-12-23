package eu.happycoders.adventofcode2015.day23;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p><code>tpl r</code> sets register <code>r</code> to <b>triple</b> its current value, then
 * continues with the next instruction.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class TripleInstruction extends RegisterModificationInstruction {

  TripleInstruction(RegisterName registerName) {
    super(registerName);
  }

  @Override
  void apply(Register register) {
    register.setValue(register.getValue() * 3);
  }

  @Override
  public String toString() {
    return "tpl " + registerName;
  }
}
