package eu.happycoders.adventofcode2015.day16;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

class SuePredicatePart1Test {

  @Test
  void givenSue1AndAMatchingPredicate_test_returnsTrue() {
    Sue sue = TestInputs.SUE1;
    SuePredicatePart1 predicate = new SuePredicatePart1(createRequiredProperties());

    boolean matches = predicate.test(sue);

    assertThat(matches).isTrue();
  }

  @Test
  void givenSue2AndANonMatchingPredicate_test_returnsFalse() {
    Sue sue = TestInputs.SUE2;
    SuePredicatePart1 predicate = new SuePredicatePart1(createRequiredProperties());

    boolean matches = predicate.test(sue);

    assertThat(matches).isFalse();
  }

  private static Map<String, Integer> createRequiredProperties() {
    Map<String, Integer> result = new HashMap<>();
    result.put("goldfish", 6);
    result.put("trees", 9);
    result.put("perfumes", 1);
    return result;
  }
}
