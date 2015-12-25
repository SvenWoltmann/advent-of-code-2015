package eu.happycoders.adventofcode2015.day25;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Code generator.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class CodeGenerator {

  private static final int SEED = 20_151_125;

  static int getCode(int iterations) {
    int code = SEED;
    for (int i = 0; i < iterations; i++) {
      code = (int) (code * 252_533L % 33_554_393);
    }
    return code;
  }
}
