package eu.happycoders.adventofcode2015.day16;

import java.util.Map;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Checks if a {@link Sue} matching the requested properties - concrete implementation for part
 * one.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class SuePredicatePart1 extends SuePredicate {

  SuePredicatePart1(Map<String, Integer> requestedProperties) {
    super(requestedProperties);
  }

  @Override
  boolean propertyMatchesRequestedValue(SueProperty sueProperty, int requestedValue) {
    System.out.println(
        "sueProperty = "
            + sueProperty.name()
            + ":"
            + sueProperty.value()
            + "; requestedValue = "
            + requestedValue);
    return sueProperty.value() == requestedValue;
  }
}
