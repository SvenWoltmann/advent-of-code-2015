package eu.happycoders.adventofcode2015.day13;

import java.util.Arrays;
import java.util.List;

class TestInputs {

  static final String TEST_INPUT =
      "Alice would gain 54 happiness units by sitting next to Bob.\n"
          + "Alice would lose 79 happiness units by sitting next to Carol.\n"
          + "Alice would lose 2 happiness units by sitting next to David.\n"
          + "Bob would gain 83 happiness units by sitting next to Alice.\n"
          + "Bob would lose 7 happiness units by sitting next to Carol.\n"
          + "Bob would lose 63 happiness units by sitting next to David.\n"
          + "Carol would lose 62 happiness units by sitting next to Alice.\n"
          + "Carol would gain 60 happiness units by sitting next to Bob.\n"
          + "Carol would gain 55 happiness units by sitting next to David.\n"
          + "David would gain 46 happiness units by sitting next to Alice.\n"
          + "David would lose 7 happiness units by sitting next to Bob.\n"
          + "David would gain 41 happiness units by sitting next to Carol.\n";

  static final List<PotentialHappiness> TEST_POTENTIAL_HAPPINESSES =
      Arrays.asList(
          new PotentialHappiness(new PersonAndNeighbor("Alice", "Bob"), 54),
          new PotentialHappiness(new PersonAndNeighbor("Alice", "Carol"), -79),
          new PotentialHappiness(new PersonAndNeighbor("Alice", "David"), -2),
          new PotentialHappiness(new PersonAndNeighbor("Bob", "Alice"), 83),
          new PotentialHappiness(new PersonAndNeighbor("Bob", "Carol"), -7),
          new PotentialHappiness(new PersonAndNeighbor("Bob", "David"), -63),
          new PotentialHappiness(new PersonAndNeighbor("Carol", "Alice"), -62),
          new PotentialHappiness(new PersonAndNeighbor("Carol", "Bob"), 60),
          new PotentialHappiness(new PersonAndNeighbor("Carol", "David"), 55),
          new PotentialHappiness(new PersonAndNeighbor("David", "Alice"), 46),
          new PotentialHappiness(new PersonAndNeighbor("David", "Bob"), -7),
          new PotentialHappiness(new PersonAndNeighbor("David", "Carol"), 41));
}
