package eu.happycoders.adventofcode2015.day4;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Calculates the MD5 hash for a given secreat key and number.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class Md5HashCalculator {

  static byte[] calculateMd5Hash(String secretKey, int number) {
    String input = secretKey + number;
    return getMd5MessageDigest().digest(input.getBytes(StandardCharsets.UTF_8));
  }

  private static MessageDigest getMd5MessageDigest() {
    try {
      return MessageDigest.getInstance("MD5");
    } catch (NoSuchAlgorithmException e) {
      throw new AssertionError(e);
    }
  }
}
