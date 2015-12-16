package eu.happycoders.adventofcode2015.day16;

import java.util.Map;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Checks if a {@link Sue} matching the requested properties - concrete implementation for part
 * two.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class SuePredicatePart2 extends SuePredicate {

  SuePredicatePart2(Map<String, Integer> requestedProperties) {
    super(requestedProperties);
  }

  @Override
  boolean propertyMatchesRequestedValue(SueProperty sueProperty, int requestedValue) {
    String name = sueProperty.name();

    if (name.equals("cats") || name.equals("trees")) {
      return sueProperty.value() >= requestedValue;
    }

    if (name.equals("pomeranians") || name.equals("goldfish")) {
      return sueProperty.value() < requestedValue;
    }

    return sueProperty.value() == requestedValue;
  }
}
