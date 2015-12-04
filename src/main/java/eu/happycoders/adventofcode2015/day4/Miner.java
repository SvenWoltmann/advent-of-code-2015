package eu.happycoders.adventofcode2015.day4;

import java.util.NoSuchElementException;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>The AdventCoins miner.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class Miner {

  static int mine(String secretKey, int requiredNumberOfZeros) {
    for (int number = 1; number < Integer.MAX_VALUE; number++) {
      if (md5HashStartsWithZeros(secretKey, number, requiredNumberOfZeros)) {
        return number;
      }
    }
    throw new NoSuchElementException();
  }

  static boolean md5HashStartsWithZeros(String secretKey, int number, int requiredNumberOfZeros) {
    byte[] hash = Md5HashCalculator.calculateMd5Hash(secretKey, number);

    // Checking for the zeros in the byte array  takes only half the time of first converting the
    // byte array to a hex string and then checking for zeros in that string.
    return hashStartWithZeros(hash, requiredNumberOfZeros);
  }

  static boolean hashStartWithZeros(byte[] hash, int requiredNumberOfZeros) {
    int fullBytesToBeZero = requiredNumberOfZeros / 2;
    for (int i = 0; i < fullBytesToBeZero; i++) {
      if (hash[i] != 0) {
        return false;
      }
    }

    boolean nextHalfByteMustBeZero = requiredNumberOfZeros % 2 != 0;
    if (nextHalfByteMustBeZero) {
      return (hash[fullBytesToBeZero] | 0x0f) == 0x0f;
    } else {
      return true;
    }
  }
}
