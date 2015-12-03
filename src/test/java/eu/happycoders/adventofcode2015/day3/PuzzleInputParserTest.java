package eu.happycoders.adventofcode2015.day3;

import static eu.happycoders.adventofcode2015.day3.Direction.EAST;
import static eu.happycoders.adventofcode2015.day3.Direction.NORTH;
import static eu.happycoders.adventofcode2015.day3.Direction.SOUTH;
import static eu.happycoders.adventofcode2015.day3.Direction.WEST;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PuzzleInputParserTest {

  private static Stream<Arguments> puzzleInputAndListOfDirections() {
    return Stream.of(
        Arguments.of(">", Collections.singletonList(EAST)),
        Arguments.of("^>v<", Arrays.asList(NORTH, EAST, SOUTH, WEST)),
        Arguments.of(
            "^v^v^v^v^v",
            Arrays.asList(NORTH, SOUTH, NORTH, SOUTH, NORTH, SOUTH, NORTH, SOUTH, NORTH, SOUTH)));
  }

  @ParameterizedTest
  @MethodSource("puzzleInputAndListOfDirections")
  void givenTestInput_parse_returnsParsedDirections(
      String input, List<Direction> expectedDirections) {
    List<Direction> directions = PuzzleInputParser.parse(input);

    assertThat(directions).isEqualTo(expectedDirections);
  }
}
