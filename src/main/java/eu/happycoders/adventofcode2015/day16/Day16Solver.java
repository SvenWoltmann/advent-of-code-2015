package eu.happycoders.adventofcode2015.day16;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Puzzle solver for day 16.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class Day16Solver {

  private static final Map<String, Integer> REQUESTED_PROPERTIES = createRequestedProperties();

  private static Map<String, Integer> createRequestedProperties() {
    Map<String, Integer> result = new HashMap<>();

    result.put("children", 3);
    result.put("cats", 7);
    result.put("samoyeds", 2);
    result.put("pomeranians", 3);
    result.put("akitas", 0);
    result.put("vizslas", 0);
    result.put("goldfish", 5);
    result.put("trees", 3);
    result.put("cars", 2);
    result.put("perfumes", 1);

    return result;
  }

  static int solvePart1(String input) {
    List<Sue> sues = PuzzleInputParser.parse(input);
    System.out.println("sues = " + sues);
    SuePredicate predicate = new SuePredicatePart1(REQUESTED_PROPERTIES);
    return sues.stream()
        .filter(predicate)
        .findFirst()
        .orElseThrow(NoSuchElementException::new)
        .number();
  }

  static int solvePart2(String input) {
    List<Sue> sues = PuzzleInputParser.parse(input);
    SuePredicate predicate = new SuePredicatePart2(REQUESTED_PROPERTIES);
    return sues.stream()
        .filter(predicate)
        .findFirst()
        .orElseThrow(NoSuchElementException::new)
        .number();
  }
}
