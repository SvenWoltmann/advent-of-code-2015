package eu.happycoders.adventofcode2015.day1;

import static eu.happycoders.adventofcode2015.day1.Direction.DOWN;
import static eu.happycoders.adventofcode2015.day1.Direction.UP;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>The instructions (go up / down) for Santa.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class Instructions implements Iterator<Direction> {

  private final String input;
  private int position;

  Instructions(String input) {
    this.input = input;
  }

  @Override
  public boolean hasNext() {
    return position < input.length();
  }

  @Override
  public Direction next() {
    if (position == input.length()) {
      throw new NoSuchElementException();
    }

    char character = input.charAt(position);
    position++;
    switch (character) {
      case '(':
        return UP;
      case ')':
        return DOWN;
      default:
        throw new IllegalArgumentException();
    }
  }
}
