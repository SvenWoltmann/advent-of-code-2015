package eu.happycoders.adventofcode2015.day22;

import java.util.Optional;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Puzzle solver for day 22.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class Day22Solver {

  static int solvePart1(String input) {
    PlayerStats bossStats = PuzzleInputParser.parse(input);
    GameState startingGameState = GameState.startGame(50, 500, bossStats, false);
    Optional<SequenceOfSpells> spells =
        StrategyFinder.findCheapestSequenceOfSpellsToWin(startingGameState);
    return spells.orElseThrow(AssertionError::new).getTotalCost();
  }

  static int solvePart2(String input) {
    PlayerStats bossStats = PuzzleInputParser.parse(input);
    GameState startingGameState = GameState.startGame(50, 500, bossStats, true);
    Optional<SequenceOfSpells> spells =
        StrategyFinder.findCheapestSequenceOfSpellsToWin(startingGameState);
    return spells.orElseThrow(AssertionError::new).getTotalCost();
  }
}
