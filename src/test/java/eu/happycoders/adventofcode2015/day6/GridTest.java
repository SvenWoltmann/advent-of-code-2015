package eu.happycoders.adventofcode2015.day6;

import static eu.happycoders.adventofcode2015.day6.Command.TOGGLE;
import static eu.happycoders.adventofcode2015.day6.Command.TURN_OFF;
import static eu.happycoders.adventofcode2015.day6.Command.TURN_ON;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GridTest {

  private Grid grid;

  @BeforeEach
  void setUpGrid() {
    grid = new Grid();
  }

  @Test
  void
      givenTurnOn0x0through999x999_andGivenPart1Translator_calculateTotalBrightness_returns1000000() {
    grid.apply(
        new Instruction(TURN_ON, new Position(0, 0), new Position(999, 999)),
        CommandTranslator.PART_1_TRANSLATOR);

    int totalBrightness = grid.calculateTotalBrightness();

    assertThat(totalBrightness).isEqualTo(1_000_000);
  }

  @Test
  void givenToggle0x0through999x0_andGivenPart1Translator_calculateTotalBrightness_returns1000() {
    grid.apply(
        new Instruction(TOGGLE, new Position(0, 0), new Position(999, 0)),
        CommandTranslator.PART_1_TRANSLATOR);

    int totalBrightness = grid.calculateTotalBrightness();

    assertThat(totalBrightness).isEqualTo(1_000);
  }

  @Test
  void
      givenTurnOn0x0through999x999ThenToggle0x0through999x0_andGivenPart1Translator_calculateTotalBrightness_returns999000() {
    grid.apply(
        new Instruction(TURN_ON, new Position(0, 0), new Position(999, 999)),
        CommandTranslator.PART_1_TRANSLATOR);
    grid.apply(
        new Instruction(TOGGLE, new Position(0, 0), new Position(999, 0)),
        CommandTranslator.PART_1_TRANSLATOR);

    int totalBrightness = grid.calculateTotalBrightness();

    assertThat(totalBrightness).isEqualTo(999_000);
  }

  @Test
  void
      givenTurnOn0x0through999x999ThenToggle0x0through999x0ThenTurnOff499x499through500x500_andGivenPart1Translator_calculateTotalBrightness_returns998996() {
    grid.apply(
        new Instruction(TURN_ON, new Position(0, 0), new Position(999, 999)),
        CommandTranslator.PART_1_TRANSLATOR);
    grid.apply(
        new Instruction(TOGGLE, new Position(0, 0), new Position(999, 0)),
        CommandTranslator.PART_1_TRANSLATOR);
    grid.apply(
        new Instruction(TURN_OFF, new Position(499, 499), new Position(500, 500)),
        CommandTranslator.PART_1_TRANSLATOR);

    int totalBrightness = grid.calculateTotalBrightness();

    assertThat(totalBrightness).isEqualTo(998_996);
  }

  @Test
  void
      givenTurnOn0x0through999x999_andGivenPart2Translator_calculateTotalBrightness_returns1000000() {
    grid.apply(
        new Instruction(TURN_ON, new Position(0, 0), new Position(999, 999)),
        CommandTranslator.PART_2_TRANSLATOR);

    int totalBrightness = grid.calculateTotalBrightness();

    assertThat(totalBrightness).isEqualTo(1_000_000);
  }

  @Test
  void givenToggle0x0through999x0_andGivenPart2Translator_calculateTotalBrightness_returns2000() {
    grid.apply(
        new Instruction(TOGGLE, new Position(0, 0), new Position(999, 0)),
        CommandTranslator.PART_2_TRANSLATOR);

    int totalBrightness = grid.calculateTotalBrightness();

    assertThat(totalBrightness).isEqualTo(2_000);
  }

  @Test
  void
      givenTurnOn0x0through999x999ThenToggle0x0through999x0_andGivenPart2Translator_calculateTotalBrightness_returns1002000() {
    grid.apply(
        new Instruction(TURN_ON, new Position(0, 0), new Position(999, 999)),
        CommandTranslator.PART_2_TRANSLATOR);
    grid.apply(
        new Instruction(TOGGLE, new Position(0, 0), new Position(999, 0)),
        CommandTranslator.PART_2_TRANSLATOR);

    int totalBrightness = grid.calculateTotalBrightness();

    assertThat(totalBrightness).isEqualTo(1_002_000);
  }

  @Test
  void
      givenTurnOn0x0through999x999ThenToggle0x0through999x0ThenTurnOff499x499through500x500_andGivenPart2Translator_calculateTotalBrightness_returns1001996() {
    grid.apply(
        new Instruction(TURN_ON, new Position(0, 0), new Position(999, 999)),
        CommandTranslator.PART_2_TRANSLATOR);
    grid.apply(
        new Instruction(TOGGLE, new Position(0, 0), new Position(999, 0)),
        CommandTranslator.PART_2_TRANSLATOR);
    grid.apply(
        new Instruction(TURN_OFF, new Position(499, 499), new Position(500, 500)),
        CommandTranslator.PART_2_TRANSLATOR);

    int totalBrightness = grid.calculateTotalBrightness();

    assertThat(totalBrightness).isEqualTo(1_001_996);
  }

  @Test
  void
      givenTurnOff499x499through500x500_andGivenPart2Translator_calculateTotalBrightness_returns0() {
    grid.apply(
        new Instruction(TURN_OFF, new Position(499, 499), new Position(500, 500)),
        CommandTranslator.PART_2_TRANSLATOR);

    int totalBrightness = grid.calculateTotalBrightness();

    assertThat(totalBrightness).isZero();
  }
}
