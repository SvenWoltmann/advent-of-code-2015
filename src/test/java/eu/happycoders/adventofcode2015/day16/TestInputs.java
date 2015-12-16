package eu.happycoders.adventofcode2015.day16;

import java.util.Arrays;

class TestInputs {

  static final String TEST_INPUT =
      "Sue 1: goldfish: 6, trees: 9, akitas: 0\n"
          + "Sue 2: goldfish: 7, trees: 1, akitas: 0\n"
          + "Sue 3: cars: 10, akitas: 6, perfumes: 7\n"
          + "Sue 4: cats: 6, pomeranians: 4, cars: 9\n"
          + "Sue 5: cars: 2, perfumes: 1, goldfish: 5\n"
          + "Sue 6: trees: 8, perfumes: 1, cars: 2";

  static final Sue SUE1 =
      new Sue(
          1,
          Arrays.asList(
              new SueProperty("goldfish", 6),
              new SueProperty("trees", 9),
              new SueProperty("akitas", 0)));

  static final Sue SUE2 =
      new Sue(
          2,
          Arrays.asList(
              new SueProperty("goldfish", 7),
              new SueProperty("trees", 1),
              new SueProperty("akitas", 0)));

  static final Sue SUE3 =
      new Sue(
          3,
          Arrays.asList(
              new SueProperty("cars", 10),
              new SueProperty("akitas", 6),
              new SueProperty("perfumes", 7)));

  static final Sue SUE4 =
      new Sue(
          4,
          Arrays.asList(
              new SueProperty("cats", 6),
              new SueProperty("pomeranians", 4),
              new SueProperty("cars", 9)));

  static final Sue SUE5 =
      new Sue(
          5,
          Arrays.asList(
              new SueProperty("cars", 2),
              new SueProperty("perfumes", 1),
              new SueProperty("goldfish", 5)));

  static final Sue SUE6 =
      new Sue(
          6,
          Arrays.asList(
              new SueProperty("trees", 8),
              new SueProperty("perfumes", 1),
              new SueProperty("cars", 2)));
}
