package eu.happycoders.adventofcode2015.day18;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class GridWithCornerLightsOnTest {

  @Test
  void givenAGridWithTheTestLitLightsAndTheCornerLightsAlwaysOn_nextStep1x_expectedLightsAreOn() {
    Grid grid = new Grid(TestInputs.TEST_LIT_LIGHTS);
    grid.setCornerLightsAlwaysOn(true);

    grid.nextStep();

    assertThat(grid.getLitLights())
        .containsExactlyInAnyOrder(
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
            new Position(5, 5));
  }

  @Test
  void
      givenAGridWithTheTestLitLightsAndTheCornerLightsAlwaysOn_nextStep1x_countLitLightsReturns18() {
    Grid grid = new Grid(TestInputs.TEST_LIT_LIGHTS);
    grid.setCornerLightsAlwaysOn(true);

    grid.nextStep();

    assertThat(grid.countLitLights()).isEqualTo(18);
  }

  @Test
  void givenAGridWithTheTestLitLightsAndTheCornerLightsAlwaysOn_nextSteps2_expectedLightsAreOn() {
    Grid grid = new Grid(TestInputs.TEST_LIT_LIGHTS);
    grid.setCornerLightsAlwaysOn(true);

    grid.nextSteps(2);

    assertThat(grid.getLitLights())
        .containsExactlyInAnyOrder(
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
            new Position(5, 5));
  }

  @Test
  void
      givenAGridWithTheTestLitLightsAndTheCornerLightsAlwaysOn_nextSteps2_countLitLightsReturns18() {
    Grid grid = new Grid(TestInputs.TEST_LIT_LIGHTS);
    grid.setCornerLightsAlwaysOn(true);

    grid.nextSteps(2);

    assertThat(grid.countLitLights()).isEqualTo(18);
  }

  @Test
  void givenAGridWithTheTestLitLightsAndTheCornerLightsAlwaysOn_nextSteps3_expectedLightsAreOn() {
    Grid grid = new Grid(TestInputs.TEST_LIT_LIGHTS);
    grid.setCornerLightsAlwaysOn(true);

    grid.nextSteps(3);

    assertThat(grid.getLitLights())
        .containsExactlyInAnyOrder(
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
            new Position(5, 5));
  }

  @Test
  void
      givenAGridWithTheTestLitLightsAndTheCornerLightsAlwaysOn_nextSteps3_countLitLightsReturns18() {
    Grid grid = new Grid(TestInputs.TEST_LIT_LIGHTS);
    grid.setCornerLightsAlwaysOn(true);

    grid.nextSteps(3);

    assertThat(grid.countLitLights()).isEqualTo(18);
  }

  @Test
  void givenAGridWithTheTestLitLightsAndTheCornerLightsAlwaysOn_nextSteps4_expectedLightsAreOn() {
    Grid grid = new Grid(TestInputs.TEST_LIT_LIGHTS);
    grid.setCornerLightsAlwaysOn(true);

    grid.nextSteps(4);

    assertThat(grid.getLitLights())
        .containsExactlyInAnyOrder(
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
            new Position(5, 5));
  }

  @Test
  void
      givenAGridWithTheTestLitLightsAndTheCornerLightsAlwaysOn_nextSteps4_countLitLightsReturns14() {
    Grid grid = new Grid(TestInputs.TEST_LIT_LIGHTS);
    grid.setCornerLightsAlwaysOn(true);

    grid.nextSteps(4);

    assertThat(grid.countLitLights()).isEqualTo(14);
  }

  @Test
  void givenAGridWithTheTestLitLightsAndTheCornerLightsAlwaysOn_nextSteps5_expectedLightsAreOn() {
    Grid grid = new Grid(TestInputs.TEST_LIT_LIGHTS);
    grid.setCornerLightsAlwaysOn(true);

    grid.nextSteps(5);

    assertThat(grid.getLitLights())
        .containsExactlyInAnyOrder(
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
            new Position(5, 5));
  }

  @Test
  void
      givenAGridWithTheTestLitLightsAndTheCornerLightsAlwaysOn_nextSteps5_countLitLightsReturns17() {
    Grid grid = new Grid(TestInputs.TEST_LIT_LIGHTS);
    grid.setCornerLightsAlwaysOn(true);

    grid.nextSteps(5);

    assertThat(grid.countLitLights()).isEqualTo(17);
  }
}
