package eu.happycoders.adventofcode2015.day18;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class GridTest {

  @Test
  void givenAGridWithTheTestLitLights_nextStep1x_expectedLightsAreOn() {
    Grid grid = new Grid(TestInputs.TEST_LIT_LIGHTS);

    grid.nextStep();

    assertThat(grid.getLitLights())
        .containsExactlyInAnyOrder(
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
            new Position(3, 5));
  }

  @Test
  void givenAGridWithTheTestLitLights_nextStep1x_countLitLightsReturns11() {
    Grid grid = new Grid(TestInputs.TEST_LIT_LIGHTS);

    grid.nextStep();

    assertThat(grid.countLitLights()).isEqualTo(11);
  }

  @Test
  void givenAGridWithTheTestLitLights_nextSteps2_expectedLightsAreOn() {
    Grid grid = new Grid(TestInputs.TEST_LIT_LIGHTS);

    grid.nextSteps(2);

    assertThat(grid.getLitLights())
        .containsExactlyInAnyOrder(
            new Position(2, 0),
            new Position(3, 0),
            new Position(4, 0),
            new Position(2, 2),
            new Position(3, 2),
            new Position(4, 2),
            new Position(1, 4),
            new Position(1, 5));
  }

  @Test
  void givenAGridWithTheTestLitLights_nextSteps2_countLitLightsReturns8() {
    Grid grid = new Grid(TestInputs.TEST_LIT_LIGHTS);

    grid.nextSteps(2);

    assertThat(grid.countLitLights()).isEqualTo(8);
  }

  @Test
  void givenAGridWithTheTestLitLights_nextSteps3_expectedLightsAreOn() {
    Grid grid = new Grid(TestInputs.TEST_LIT_LIGHTS);

    grid.nextSteps(3);

    assertThat(grid.getLitLights())
        .containsExactlyInAnyOrder(
            new Position(3, 0), new Position(3, 2), new Position(2, 3), new Position(3, 3));
  }

  @Test
  void givenAGridWithTheTestLitLights_nextSteps3_countLitLightsReturns4() {
    Grid grid = new Grid(TestInputs.TEST_LIT_LIGHTS);

    grid.nextSteps(3);

    assertThat(grid.countLitLights()).isEqualTo(4);
  }

  @Test
  void givenAGridWithTheTestLitLights_nextSteps4_expectedLightsAreOn() {
    Grid grid = new Grid(TestInputs.TEST_LIT_LIGHTS);

    grid.nextSteps(4);

    assertThat(grid.getLitLights())
        .containsExactlyInAnyOrder(
            new Position(2, 2), new Position(3, 2), new Position(2, 3), new Position(3, 3));
  }

  @Test
  void givenAGridWithTheTestLitLights_nextSteps4_countLitLightsReturns4() {
    Grid grid = new Grid(TestInputs.TEST_LIT_LIGHTS);

    grid.nextSteps(4);

    assertThat(grid.countLitLights()).isEqualTo(4);
  }
}
