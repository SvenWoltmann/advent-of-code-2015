package eu.happycoders.adventofcode2015.day21;

import static eu.happycoders.adventofcode2015.day21.Shop.CHAINMAIL;
import static eu.happycoders.adventofcode2015.day21.Shop.DAGGER;
import static eu.happycoders.adventofcode2015.day21.Shop.DAMAGE_1;
import static eu.happycoders.adventofcode2015.day21.Shop.DEFENSE_1;
import static eu.happycoders.adventofcode2015.day21.Shop.LEATHER;
import static eu.happycoders.adventofcode2015.day21.Shop.SHORTSWORD;
import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

class ItemSetsCompositorTest {

  @Test
  void givenSomeItems_generateAllPossibleItemSets_returnsAllAllowedCompositions() {
    // given
    List<Item> weapons = Arrays.asList(DAGGER, SHORTSWORD);
    List<Item> armors = Arrays.asList(LEATHER, CHAINMAIL);
    List<Item> rings = Arrays.asList(Shop.DAMAGE_1, DEFENSE_1);

    // when
    List<ItemSet> itemSets = ItemSetsCompositor.generateAllPossibleItemSets(weapons, armors, rings);

    // then
    List<Item> noRings = emptyList();
    List<Item> ring1 = Collections.singletonList(DAMAGE_1);
    List<Item> ring2 = Collections.singletonList(DEFENSE_1);
    List<Item> bothRings = Arrays.asList(DAMAGE_1, DEFENSE_1);

    assertThat(itemSets)
        .containsExactlyInAnyOrder(
            new ItemSet(DAGGER, null, noRings),
            new ItemSet(DAGGER, null, ring1),
            new ItemSet(DAGGER, null, ring2),
            new ItemSet(DAGGER, null, bothRings),
            new ItemSet(DAGGER, LEATHER, noRings),
            new ItemSet(DAGGER, LEATHER, ring1),
            new ItemSet(DAGGER, LEATHER, ring2),
            new ItemSet(DAGGER, LEATHER, bothRings),
            new ItemSet(DAGGER, CHAINMAIL, noRings),
            new ItemSet(DAGGER, CHAINMAIL, ring1),
            new ItemSet(DAGGER, CHAINMAIL, ring2),
            new ItemSet(DAGGER, CHAINMAIL, bothRings),
            new ItemSet(SHORTSWORD, null, noRings),
            new ItemSet(SHORTSWORD, null, ring1),
            new ItemSet(SHORTSWORD, null, ring2),
            new ItemSet(SHORTSWORD, null, bothRings),
            new ItemSet(SHORTSWORD, LEATHER, noRings),
            new ItemSet(SHORTSWORD, LEATHER, ring1),
            new ItemSet(SHORTSWORD, LEATHER, ring2),
            new ItemSet(SHORTSWORD, LEATHER, bothRings),
            new ItemSet(SHORTSWORD, CHAINMAIL, noRings),
            new ItemSet(SHORTSWORD, CHAINMAIL, ring1),
            new ItemSet(SHORTSWORD, CHAINMAIL, ring2),
            new ItemSet(SHORTSWORD, CHAINMAIL, bothRings));
  }
}
