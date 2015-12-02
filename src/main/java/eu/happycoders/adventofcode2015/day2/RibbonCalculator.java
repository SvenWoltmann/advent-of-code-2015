package eu.happycoders.adventofcode2015.day2;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Calculates the required ribbon for a present.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class RibbonCalculator {

  static int calculateRequiredRibbonLength(Dimensions dimensions) {
    int perimeter1 = 2 * (dimensions.length() + dimensions.width());
    int perimeter2 = 2 * (dimensions.width() + dimensions.height());
    int perimeter3 = 2 * (dimensions.height() + dimensions.length());
    int smallestPerimeter = Math.min(Math.min(perimeter1, perimeter2), perimeter3);

    int volume = dimensions.length() * dimensions.width() * dimensions.height();

    return smallestPerimeter + volume;
  }
}
