package eu.happycoders.adventofcode2015.day7;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>A gate whose output is fed to another wire.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
abstract class Gate implements WireSource {

  Integer signal;

  @Override
  public int getSignal() {
    if (signal == null) {
      signal = applyOperation();
    }
    return signal;
  }

  abstract int applyOperation();
}
