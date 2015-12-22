package eu.happycoders.adventofcode2015.day22;

import static eu.happycoders.adventofcode2015.day22.Player.BOSS;
import static eu.happycoders.adventofcode2015.day22.Player.PLAYER;
import static java.lang.Math.max;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>A state of the game after a certain number of rounds. The game state is immutable and returns
 * a new game state for every change, so we can keep different game states in a breadth-first-search
 * queue.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
final class GameState {

  private final int playerHitPoints;
  private final int playerMana;
  private final SequenceOfSpells sequenceOfSpells;

  private final int bossHitPoints;
  private final int bossDamage;

  private final boolean difficult;

  private final Player currentPlayer;
  private final Player winner;

  @SuppressWarnings("squid:S107") // Allow a private constructor with more than 7 parameters
  private GameState(
      int playerHitPoints,
      int playerMana,
      SequenceOfSpells sequenceOfSpells,
      int bossHitPoints,
      int bossDamage,
      boolean difficult,
      Player currentPlayer,
      Player winner) {
    this.playerHitPoints = playerHitPoints;
    this.playerMana = playerMana;
    this.sequenceOfSpells = sequenceOfSpells;
    this.bossHitPoints = bossHitPoints;
    this.bossDamage = bossDamage;
    this.difficult = difficult;
    this.currentPlayer = currentPlayer;
    this.winner = winner;
  }

  static GameState startGame(
      int playerHitPoints, int playerMana, PlayerStats bossStats, boolean difficult) {
    return new GameState(
        playerHitPoints,
        playerMana,
        new SequenceOfSpells(),
        bossStats.hitPoints(),
        bossStats.damage(),
        difficult,
        PLAYER,
        null);
  }

  List<SpellType> getAvailableSpellTypes() {
    return Arrays.stream(SpellType.values())
        .filter(spellType -> spellType.cost() <= playerMana)
        .filter(sequenceOfSpells::isNotActiveAfterDecreasingTheTimer)
        .collect(Collectors.toList());
  }

  GameState playPlayerRound(SpellType spellType) {
    Objects.requireNonNull(spellType);

    if (currentPlayer != PLAYER) {
      throw new IllegalStateException("Not player's round");
    }

    return playRound(spellType);
  }

  @SuppressWarnings("squid:S2259") // False positive, there won't be an NPE on spellType
  GameState playBossRound() {
    if (currentPlayer != BOSS) {
      throw new IllegalStateException("Not boss's round");
    }

    return playRound(null);
  }

  private GameState playRound(SpellType spellType) {
    if (winner != null) {
      throw new IllegalStateException("The game has already ended with " + winner + " as winner");
    }

    int newPlayerHitPoints = playerHitPoints;

    // Increased difficulty for part 2
    if (difficult && currentPlayer == PLAYER) {
      newPlayerHitPoints--;
      if (newPlayerHitPoints == 0) {
        return createBossWinsGameState(newPlayerHitPoints);
      }
    }

    // Apply spell effects
    SumOfSpellEffects sumOfActiveSpellEffects = sequenceOfSpells.getSumOfActiveSpellEffects();
    int newBossHitPoints = bossHitPoints - sumOfActiveSpellEffects.damage();
    int newPlayerMana = playerMana + sumOfActiveSpellEffects.newMana();

    // Decrease timers (on a deep copy of the spell sequence)
    SequenceOfSpells newSequenceOfSpells = sequenceOfSpells.deepCopy();
    newSequenceOfSpells.decreaseTimers();

    // Cast new spell
    if (currentPlayer == PLAYER) {
      newSequenceOfSpells.cast(spellType);
      newBossHitPoints -= spellType.instantDamage();
      newPlayerHitPoints += spellType.instantHeal();
      newPlayerMana -= spellType.cost();
    }

    // Apply damage by boss
    if (currentPlayer == BOSS) {
      int damage = max(bossDamage - sumOfActiveSpellEffects.armor(), 1);
      newPlayerHitPoints -= damage;
    }

    Player newWinner = calculateNewWinner(newPlayerHitPoints, newBossHitPoints);

    return new GameState(
        newPlayerHitPoints,
        newPlayerMana,
        newSequenceOfSpells,
        newBossHitPoints,
        bossDamage,
        difficult,
        otherPlayer(),
        newWinner);
  }

  private GameState createBossWinsGameState(int newPlayerHitPoints) {
    return new GameState(
        newPlayerHitPoints,
        playerMana,
        sequenceOfSpells,
        bossHitPoints,
        bossDamage,
        difficult,
        otherPlayer(),
        BOSS);
  }

  private Player calculateNewWinner(int newPlayerHitPoints, int newBossHitPoints) {
    if (newBossHitPoints <= 0) {
      return PLAYER;
    }
    if (newPlayerHitPoints <= 0) {
      return BOSS;
    }
    return null;
  }

  private Player otherPlayer() {
    return currentPlayer == BOSS ? PLAYER : BOSS;
  }

  boolean hasWinner() {
    return winner != null;
  }

  Player getWinner() {
    return winner;
  }

  int getTotalCost() {
    return sequenceOfSpells.getTotalCost();
  }

  SequenceOfSpells getSequenceOfSpells() {
    return sequenceOfSpells;
  }
}
