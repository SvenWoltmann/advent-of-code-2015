package eu.happycoders.adventofcode2015.day15;

import java.util.Arrays;
import java.util.List;

class TestInputs {

  static final String TEST_INPUT =
      "Butterscotch: capacity -1, durability -2, flavor 6, texture 3, calories 8\n"
          + "Cinnamon: capacity 2, durability 3, flavor -2, texture -1, calories 3";

  static final List<Ingredient> TEST_INGREDIENTS =
      Arrays.asList(
          new Ingredient("Butterscotch", -1, -2, 6, 3, 8),
          new Ingredient("Cinnamon", 2, 3, -2, -1, 3));
}
