package eu.happycoders.adventofcode2015.day18;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class GridWithCornerLightsOnTest {

  @ParameterizedTest(name = "after {0} step(s), the expected lights are on")
  @MethodSource("stepsAndExpectedLitLights")
  void givenAGridWithTheTestLitLightsAndTheCornerLightsAlwaysOn_nextSteps_expectedLightsAreOn(
      int steps, List<Position> expectedLitLights) {
    Grid grid = new Grid(TestInputs.TEST_LIT_LIGHTS);
    grid.setCornerLightsAlwaysOn(true);

    grid.nextSteps(steps);

    assertThat(grid.getLitLights()).containsExactlyInAnyOrderElementsOf(expectedLitLights);
  }

  static Stream<Arguments> stepsAndExpectedLitLights() {
    return Stream.of(
        arguments(
            1,
            List.of(
                new Position(0, 0),
                new Position(2, 0),
                new Position(3, 0),
                new Position(5, 0),
                new Position(0, 1),
                new Position(1, 1),
                new Position(2, 1),
                new Position(3, 1),
                new Position(5, 1),
                new Position(3, 2),
                new Position(4, 2),
                new Position(0, 4),
                new Position(4, 4),
                new Position(0, 5),
                new Position(2, 5),
                new Position(3, 5),
                new Position(4, 5),
                new Position(5, 5))),
        arguments(
            2,
            List.of(
                new Position(0, 0),
                new Position(3, 0),
                new Position(5, 0),
                new Position(0, 1),
                new Position(5, 1),
                new Position(1, 2),
                new Position(3, 2),
                new Position(4, 2),
                new Position(3, 3),
                new Position(4, 3),
                new Position(1, 4),
                new Position(4, 4),
                new Position(5, 4),
                new Position(0, 5),
                new Position(1, 5),
                new Position(3, 5),
                new Position(4, 5),
                new Position(5, 5))),
        arguments(
            3,
            List.of(
                new Position(0, 0),
                new Position(4, 0),
                new Position(5, 0),
                new Position(0, 1),
                new Position(1, 1),
                new Position(2, 1),
                new Position(3, 1),
                new Position(5, 1),
                new Position(2, 2),
                new Position(3, 2),
                new Position(5, 2),
                new Position(0, 4),
                new Position(1, 4),
                new Position(0, 5),
                new Position(1, 5),
                new Position(2, 5),
                new Position(3, 5),
                new Position(5, 5))),
        arguments(
            4,
            List.of(
                new Position(0, 0),
                new Position(2, 0),
                new Position(3, 0),
                new Position(4, 0),
                new Position(5, 0),
                new Position(0, 1),
                new Position(5, 1),
                new Position(3, 2),
                new Position(1, 3),
                new Position(2, 3),
                new Position(0, 4),
                new Position(0, 5),
                new Position(2, 5),
                new Position(5, 5))),
        arguments(
            5,
            List.of(
                new Position(0, 0),
                new Position(1, 0),
                new Position(3, 0),
                new Position(4, 0),
                new Position(5, 0),
                new Position(1, 1),
                new Position(2, 1),
                new Position(5, 1),
                new Position(1, 2),
                new Position(2, 2),
                new Position(1, 3),
                new Position(2, 3),
                new Position(0, 4),
                new Position(2, 4),
                new Position(0, 5),
                new Position(1, 5),
                new Position(5, 5))));
  }

  @ParameterizedTest(name = "after {0} step(s), {1} lights are lit")
  @CsvSource({"1, 18", "2, 18", "3, 18", "4, 14", "5, 17"})
  void
      givenAGridWithTheTestLitLightsAndTheCornerLightsAlwaysOn_nextSteps_countLitLightsReturnsTheExpectedCount(
          int steps, int expectedCount) {
    Grid grid = new Grid(TestInputs.TEST_LIT_LIGHTS);
    grid.setCornerLightsAlwaysOn(true);

    grid.nextSteps(steps);

    assertThat(grid.countLitLights()).isEqualTo(expectedCount);
  }
}
