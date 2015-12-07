package eu.happycoders.adventofcode2015.day7;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Source a wire gets its signal from (a {@link Gate}, a {@link SpecificValue} or another {@link
 * Wire}).
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
interface WireSource {

  int getSignal();

  void reset();
}
