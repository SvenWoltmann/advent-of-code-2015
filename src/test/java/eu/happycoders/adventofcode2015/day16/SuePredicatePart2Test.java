package eu.happycoders.adventofcode2015.day16;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

class SuePredicatePart2Test {

  @Test
  void givenSue2AndExactNumberOfTreesAndMoreGoldfishAndExactNumberOfAkitas_test_returnsTrue() {
    Sue sue = TestInputs.SUE2;
    Map<String, Integer> requiredProperties = new HashMap<>();
    requiredProperties.put("trees", 1);
    requiredProperties.put("goldfish", 8);
    requiredProperties.put("akitas", 0);
    requiredProperties.put("irrelevant", 1);
    SuePredicatePart2 predicate = new SuePredicatePart2(requiredProperties);

    boolean matches = predicate.test(sue);

    assertThat(matches).isTrue();
  }

  @Test
  void givenSue2AndMoreTrees_test_returnsFalse() {
    Sue sue = TestInputs.SUE2;
    Map<String, Integer> requiredProperties = new HashMap<>();
    requiredProperties.put("trees", 2);
    SuePredicatePart2 predicate = new SuePredicatePart2(requiredProperties);

    boolean matches = predicate.test(sue);

    assertThat(matches).isFalse();
  }

  @Test
  void givenSue2AndExactNumberGoldfish_test_returnsFalse() {
    Sue sue = TestInputs.SUE2;
    Map<String, Integer> requiredProperties = new HashMap<>();
    requiredProperties.put("goldfish", 7);
    requiredProperties.put("irrelevant", 1);
    SuePredicatePart2 predicate = new SuePredicatePart2(requiredProperties);

    boolean matches = predicate.test(sue);

    assertThat(matches).isFalse();
  }

  @Test
  void givenSue2AndNotMatchingNumberOfAkitas_test_returnsFalse() {
    Sue sue = TestInputs.SUE2;
    Map<String, Integer> requiredProperties = new HashMap<>();
    requiredProperties.put("akitas", 1);
    requiredProperties.put("irrelevant", 1);
    SuePredicatePart2 predicate = new SuePredicatePart2(requiredProperties);

    boolean matches = predicate.test(sue);

    assertThat(matches).isFalse();
  }

  @Test
  void givenSue4AndExactNumberOfCatsAndMorePomeraniansAndExactNumberOfCars_test_returnsTrue() {
    Sue sue = TestInputs.SUE4;
    Map<String, Integer> requiredProperties = new HashMap<>();
    requiredProperties.put("cats", 6);
    requiredProperties.put("pomeranians", 5);
    requiredProperties.put("cars", 9);
    requiredProperties.put("irrelevant", 1);
    SuePredicatePart2 predicate = new SuePredicatePart2(requiredProperties);

    boolean matches = predicate.test(sue);

    assertThat(matches).isTrue();
  }

  @Test
  void givenSue4AndMoreCats_test_returnsFalse() {
    Sue sue = TestInputs.SUE4;
    Map<String, Integer> requiredProperties = new HashMap<>();
    requiredProperties.put("cats", 7);
    requiredProperties.put("irrelevant", 1);
    SuePredicatePart2 predicate = new SuePredicatePart2(requiredProperties);

    boolean matches = predicate.test(sue);

    assertThat(matches).isFalse();
  }

  @Test
  void givenSue4AndExactNumberOfPomeranians_test_returnsFalse() {
    Sue sue = TestInputs.SUE4;
    Map<String, Integer> requiredProperties = new HashMap<>();
    requiredProperties.put("pomeranians", 4);
    requiredProperties.put("irrelevant", 1);
    SuePredicatePart2 predicate = new SuePredicatePart2(requiredProperties);

    boolean matches = predicate.test(sue);

    assertThat(matches).isFalse();
  }

  @Test
  void givenSue4AndNotMatchingNumberOfCars_test_returnsFalse() {
    Sue sue = TestInputs.SUE4;
    Map<String, Integer> requiredProperties = new HashMap<>();
    requiredProperties.put("cars", 8);
    requiredProperties.put("irrelevant", 1);
    SuePredicatePart2 predicate = new SuePredicatePart2(requiredProperties);

    boolean matches = predicate.test(sue);

    assertThat(matches).isFalse();
  }
}
