package eu.happycoders.adventofcode2015.day2;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class PuzzleInputParserTest {

  @Test
  void givenSomeTestInput_parse_returnsTheParsedDimensions() {
    String input = "2x3x4\n1x1x10";

    List<Dimensions> listOfDimensions = PuzzleInputParser.parse(input);

    assertThat(listOfDimensions).containsExactly(new Dimensions(2, 3, 4), new Dimensions(1, 1, 10));
  }
}
