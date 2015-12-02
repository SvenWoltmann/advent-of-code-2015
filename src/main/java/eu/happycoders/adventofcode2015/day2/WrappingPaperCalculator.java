package eu.happycoders.adventofcode2015.day2;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Calculates the required wrapping paper for a present.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class WrappingPaperCalculator {

  static int calculateRequiredWrappingPaperSize(Dimensions dimensions) {
    int area1 = dimensions.length() * dimensions.width();
    int area2 = dimensions.width() * dimensions.height();
    int area3 = dimensions.height() * dimensions.length();

    int areaSmallestSide = Math.min(Math.min(area1, area2), area3);

    return 2 * area1 + 2 * area2 + 2 * area3 + areaSmallestSide;
  }
}
