package eu.happycoders.adventofcode2015.day21;

import java.util.Arrays;
import java.util.List;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>The shop contains a list of {@link Item} to be sold.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class Shop {

  static final Item DAGGER = new Item("Dagger", 8, 4, 0);
  static final Item SHORTSWORD = new Item("Shortsword", 10, 5, 0);
  static final Item WARHAMMER = new Item("Warhammer", 25, 6, 0);
  static final Item LONGSWORD = new Item("Longsword", 40, 7, 0);
  static final Item GREATAXE = new Item("Greataxe", 74, 8, 0);

  static final List<Item> WEAPONS =
      Arrays.asList(DAGGER, SHORTSWORD, WARHAMMER, LONGSWORD, GREATAXE);

  static final Item LEATHER = new Item("Leather", 13, 0, 1);
  static final Item CHAINMAIL = new Item("Chainmail", 31, 0, 2);
  static final Item SPLINTMAIL = new Item("Splintmail", 53, 0, 3);
  static final Item BANDEDMAIL = new Item("Bandedmail", 75, 0, 4);
  static final Item PLATEMAIL = new Item("Platemail", 102, 0, 5);

  static final List<Item> ARMORS =
      Arrays.asList(LEATHER, CHAINMAIL, SPLINTMAIL, BANDEDMAIL, PLATEMAIL);

  static final Item DAMAGE_1 = new Item("Damage +1", 25, 1, 0);
  static final Item DAMAGE_2 = new Item("Damage +2", 50, 2, 0);
  static final Item DAMAGE_3 = new Item("Damage +3", 100, 3, 0);
  static final Item DEFENSE_1 = new Item("Defense +1", 20, 0, 1);
  static final Item DEFENSE_2 = new Item("Defense +2", 40, 0, 2);
  static final Item DEFENSE_3 = new Item("Defense +3", 80, 0, 3);

  static final List<Item> RINGS =
      Arrays.asList(DAMAGE_1, DAMAGE_2, DAMAGE_3, DEFENSE_1, DEFENSE_2, DEFENSE_3);
}
