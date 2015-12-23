package eu.happycoders.adventofcode2015.day23;

import static eu.happycoders.adventofcode2015.day23.RegisterName.A;
import static eu.happycoders.adventofcode2015.day23.RegisterName.B;

import java.util.Arrays;
import java.util.List;

class TestInputs {

  static final String TEST_INPUT =
      "inc a\n" //
          + "jio a, +2\n"
          + "tpl a\n"
          + "inc a\n";

  static final String TEST_INPUT_EXTENDED =
      "jmp +3\n"
          + "inc a\n" // skipped
          + "inc b\n" // skipped
          + "jio a, 20\n" // skips all the rest for part 2
          + "inc a\n" // 1
          + "inc b\n" // 1
          + "tpl a\n" // 3
          + "inc b\n" // 2
          + "tpl a\n" // 9
          + "tpl b\n" // 6
          + "inc a\n" // 10
          + "inc a\n" // 11
          + "inc a\n" // 12
          + "hlf a\n" // 6 -> 3
          + "inc b\n" // 7 -> 8
          + "jie a, -2\n" // YES -> NO
          + "tpl a\n" // 9
          + "jio a, +2\n" // NO
          + "inc a\n" // 10 -> 11 -> 12
          + "hlf b\n" // 4 -> 2 -> 1
          + "jie b, -2\n" // YES -> YES -> NO
          + "jio b, +2\n" // YES
          + "inc b\n"; // skipped

  static final List<Instruction> TEST_INSTRUCTIONS =
      Arrays.asList(
          new IncInstruction(A),
          new JumpIfOneInstruction(A, 2),
          new TripleInstruction(A),
          new IncInstruction(A));

  static final List<Instruction> TEST_INSTRUCTIONS_EXTENDED =
      Arrays.asList(
          new JumpInstruction(3),
          new IncInstruction(A),
          new IncInstruction(B),
          new JumpIfOneInstruction(A, 20),
          new IncInstruction(A),
          new IncInstruction(B),
          new TripleInstruction(A),
          new IncInstruction(B),
          new TripleInstruction(A),
          new TripleInstruction(B),
          new IncInstruction(A),
          new IncInstruction(A),
          new IncInstruction(A),
          new HalfInstruction(A),
          new IncInstruction(B),
          new JumpIfEvenInstruction(A, -2),
          new TripleInstruction(A),
          new JumpIfOneInstruction(A, 2),
          new IncInstruction(A),
          new HalfInstruction(B),
          new JumpIfEvenInstruction(B, -2),
          new JumpIfOneInstruction(B, 2),
          new IncInstruction(B));
}
