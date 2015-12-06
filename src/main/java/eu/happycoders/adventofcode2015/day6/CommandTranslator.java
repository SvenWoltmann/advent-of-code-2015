package eu.happycoders.adventofcode2015.day6;

import static eu.happycoders.adventofcode2015.day6.Command.TOGGLE;
import static eu.happycoders.adventofcode2015.day6.Command.TURN_OFF;
import static eu.happycoders.adventofcode2015.day6.Command.TURN_ON;

import java.util.EnumMap;
import java.util.function.IntUnaryOperator;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Translates a command to an integer operation based on the current puzzle part.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class CommandTranslator {

  static final CommandTranslator PART_1_TRANSLATOR = createPart1Translator();

  static final CommandTranslator PART_2_TRANSLATOR = createPart2Translator();

  private final EnumMap<Command, IntUnaryOperator> commandToOperator;

  CommandTranslator(EnumMap<Command, IntUnaryOperator> commandToOperator) {
    this.commandToOperator = commandToOperator;
  }

  IntUnaryOperator getOperatorForCommand(Command command) {
    return commandToOperator.get(command);
  }

  private static CommandTranslator createPart1Translator() {
    EnumMap<Command, IntUnaryOperator> commandToOperatorPart1 = new EnumMap<>(Command.class);
    commandToOperatorPart1.put(TURN_ON, brightness -> 1);
    commandToOperatorPart1.put(TOGGLE, brightness -> 1 - brightness);
    commandToOperatorPart1.put(TURN_OFF, brightness -> 0);
    return new CommandTranslator(commandToOperatorPart1);
  }

  private static CommandTranslator createPart2Translator() {
    EnumMap<Command, IntUnaryOperator> commandToOperatorPart2 = new EnumMap<>(Command.class);
    commandToOperatorPart2.put(TURN_ON, brightness -> brightness + 1);
    commandToOperatorPart2.put(TOGGLE, brightness -> brightness + 2);
    commandToOperatorPart2.put(TURN_OFF, brightness -> Math.max(brightness - 1, 0));
    return new CommandTranslator(commandToOperatorPart2);
  }
}
