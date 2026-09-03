package eu.happycoders.adventofcode2015.day18;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class GridTest {

  @ParameterizedTest(name = "after {0} step(s), the expected lights are on")
  @MethodSource("stepsAndExpectedLitLights")
  void givenAGridWithTheTestLitLights_nextSteps_expectedLightsAreOn(
      int steps, List<Position> expectedLitLights) {
    Grid grid = new Grid(TestInputs.TEST_LIT_LIGHTS);

    grid.nextSteps(steps);

    assertThat(grid.getLitLights()).containsExactlyInAnyOrderElementsOf(expectedLitLights);
  }

  static Stream<Arguments> stepsAndExpectedLitLights() {
    return Stream.of(
        arguments(
            1,
            List.of(
                new Position(2, 0),
                new Position(3, 0),
                new Position(2, 1),
                new Position(3, 1),
                new Position(5, 1),
                new Position(3, 2),
                new Position(4, 2),
                new Position(0, 4),
                new Position(0, 5),
                new Position(2, 5),
                new Position(3, 5))),
        arguments(
            2,
            List.of(
                new Position(2, 0),
                new Position(3, 0),
                new Position(4, 0),
                new Position(2, 2),
                new Position(3, 2),
                new Position(4, 2),
                new Position(1, 4),
                new Position(1, 5))),
        arguments(
            3,
            List.of(
                new Position(3, 0), new Position(3, 2), new Position(2, 3), new Position(3, 3))),
        arguments(
            4,
            List.of(
                new Position(2, 2), new Position(3, 2), new Position(2, 3), new Position(3, 3))));
  }

  @ParameterizedTest(name = "after {0} step(s), {1} lights are lit")
  @CsvSource({"1, 11", "2, 8", "3, 4", "4, 4"})
  void givenAGridWithTheTestLitLights_nextSteps_countLitLightsReturnsTheExpectedCount(
      int steps, int expectedCount) {
    Grid grid = new Grid(TestInputs.TEST_LIT_LIGHTS);

    grid.nextSteps(steps);

    assertThat(grid.countLitLights()).isEqualTo(expectedCount);
  }
}
