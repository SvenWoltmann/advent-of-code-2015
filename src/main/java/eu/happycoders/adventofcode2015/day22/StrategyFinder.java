package eu.happycoders.adventofcode2015.day22;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.PriorityQueue;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Finds the best strategy according to the puzzle rules.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class StrategyFinder {

  private static final int CHEAPEST_SPELL_COST =
      Arrays.stream(SpellType.values()).mapToInt(SpellType::cost).min().orElse(0);

  private static GameState bestGameState;

  static Optional<SequenceOfSpells> findCheapestSequenceOfSpellsToWin(GameState startingGameState) {
    // Depth-first search of breath-first search?
    // We have not too many options per round, so we can use a breath-first search.
    // We can even use a PriorityQueue to sort the possible game states by total cost.

    // When we found a solution, and we had to skip a spell (because it was still active), there
    // could be a cheaper solution further down the queue if there's a game state that costs the
    // same or is more expensive than the current one, but that can be combined with a cheaper
    // spell. Simply check all further queue entries until the popped item plus the cheapest spell
    // reaches the current solution's cost.
    bestGameState = null;

    PriorityQueue<GameState> queue =
        new PriorityQueue<>(Comparator.comparing(GameState::getTotalCost));
    queue.add(startingGameState);

    while (!queue.isEmpty()) {
      GameState gameState = queue.poll();

      if (isNotPossibleToBeatTheBestGame(gameState)) {
        break;
      }

      List<SpellType> availableSpellTypes = gameState.getAvailableSpellTypes();
      tryAllAvailableSpellTypes(gameState, availableSpellTypes, queue);
    }

    return bestGameState != null
        ? Optional.of(bestGameState.getSequenceOfSpells())
        : Optional.empty();
  }

  private static boolean isNotPossibleToBeatTheBestGame(GameState gameState) {
    return bestGameState != null
        && gameState.getTotalCost() + CHEAPEST_SPELL_COST >= bestGameState.getTotalCost();
  }

  private static void tryAllAvailableSpellTypes(
      GameState gameState, List<SpellType> availableSpellTypes, PriorityQueue<GameState> queue) {
    for (SpellType spellType : availableSpellTypes) {
      GameState newGameState = gameState.playPlayerRound(spellType);
      if (newGameState.hasWinner()) {
        checkIfNewBestGameFound(newGameState);
        continue;
      }

      newGameState = newGameState.playBossRound();
      if (newGameState.hasWinner()) {
        checkIfNewBestGameFound(newGameState);
      } else {
        // No one won --> add this state to the queue
        queue.add(newGameState);
      }
    }
  }

  private static void checkIfNewBestGameFound(GameState newGameState) {
    Player winner = newGameState.getWinner();
    if (winner == Player.PLAYER && isBetterThanBestGame(newGameState)) {
      bestGameState = newGameState;
    }
  }

  private static boolean isBetterThanBestGame(GameState newGameState) {
    return bestGameState == null || newGameState.getTotalCost() < bestGameState.getTotalCost();
  }
}
