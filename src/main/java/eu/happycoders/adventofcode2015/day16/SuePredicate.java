package eu.happycoders.adventofcode2015.day16;

import java.util.Map;
import java.util.function.Predicate;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Checks if a {@link Sue} matching the requested properties - abstract base class.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
abstract class SuePredicate implements Predicate<Sue> {

  private final Map<String, Integer> requestedProperties;

  protected SuePredicate(Map<String, Integer> requestedProperties) {
    this.requestedProperties = requestedProperties;
  }

  @Override
  public boolean test(Sue sue) {
    for (SueProperty sueProperty : sue.properties()) {
      Integer requestedValue = requestedProperties.get(sueProperty.name());
      if (requestedValue != null && !propertyMatchesRequestedValue(sueProperty, requestedValue)) {
        return false;
      }
    }
    return true;
  }

  abstract boolean propertyMatchesRequestedValue(SueProperty sueProperty, int requestedValue);
}
