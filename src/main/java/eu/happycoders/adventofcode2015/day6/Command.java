package eu.happycoders.adventofcode2015.day6;

import java.util.Locale;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>A type of command (turn on, toggle, turn off).
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
enum Command {
  TURN_ON,
  TOGGLE,
  TURN_OFF;

  static Command parse(String input) {
    return Command.valueOf(input.toUpperCase(Locale.US).replace(' ', '_'));
  }
}
