package eu.happycoders.adventofcode2015.day21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Composes all possible {@link ItemSet}s from given weapons, armors, and rings.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class ItemSetsCompositor {

  static List<ItemSet> generateAllPossibleItemSets(
      List<Item> weapons, List<Item> armors, List<Item> rings) {
    List<ItemSet> result = new ArrayList<>();

    // 1 weapon
    for (Item weapon : weapons) {
      result.addAll(getAllPossibleCombinationsWithWeapon(weapon, armors, rings));
    }

    return result;
  }

  private static List<ItemSet> getAllPossibleCombinationsWithWeapon(
      Item weapon, List<Item> armors, List<Item> rings) {
    List<ItemSet> result = new ArrayList<>();

    // 0 armor
    result.addAll(getAllPossibleCombinationsWithWeaponAndArmor(weapon, null, rings));

    // 1 armor
    for (Item armor : armors) {
      result.addAll(getAllPossibleCombinationsWithWeaponAndArmor(weapon, armor, rings));
    }

    return result;
  }

  private static List<ItemSet> getAllPossibleCombinationsWithWeaponAndArmor(
      Item weapon, Item armor, List<Item> rings) {
    List<ItemSet> result = new ArrayList<>();

    // 0 rings
    result.add(new ItemSet(weapon, armor, Collections.emptyList()));

    // 1 ring
    for (Item ring : rings) {
      result.add(new ItemSet(weapon, armor, Collections.singletonList(ring)));
    }

    // 2 rings
    for (int i = 0; i < rings.size(); i++) {
      Item ring1 = rings.get(i);
      for (int j = i + 1; j < rings.size(); j++) {
        Item ring2 = rings.get(j);
        result.add(new ItemSet(weapon, armor, Arrays.asList(ring1, ring2)));
      }
    }

    return result;
  }
}
