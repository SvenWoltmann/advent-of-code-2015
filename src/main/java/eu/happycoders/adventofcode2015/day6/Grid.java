package eu.happycoders.adventofcode2015.day6;

import java.util.List;
import java.util.function.IntUnaryOperator;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>The two-dimensional grid of lights.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class Grid {

  private static final int WIDTH = 1000;
  private static final int HEIGHT = 1000;

  private final int[][] brightness = new int[HEIGHT][WIDTH];

  void apply(List<Instruction> instructions, CommandTranslator translator) {
    instructions.forEach(instruction -> apply(instruction, translator));
  }

  void apply(Instruction instruction, CommandTranslator translator) {
    int minX = Math.min(instruction.start().x(), instruction.end().x());
    int maxX = Math.max(instruction.start().x(), instruction.end().x());

    int minY = Math.min(instruction.start().y(), instruction.end().y());
    int maxY = Math.max(instruction.start().y(), instruction.end().y());

    for (int x = minX; x <= maxX; x++) {
      for (int y = minY; y <= maxY; y++) {
        IntUnaryOperator operator = translator.getOperatorForCommand(instruction.command());
        brightness[y][x] = operator.applyAsInt(brightness[y][x]);
      }
    }
  }

  int calculateTotalBrightness() {
    int result = 0;
    for (int y = 0; y < HEIGHT; y++) {
      for (int x = 0; x < WIDTH; x++) {
        result += brightness[y][x];
      }
    }
    return result;
  }
}
