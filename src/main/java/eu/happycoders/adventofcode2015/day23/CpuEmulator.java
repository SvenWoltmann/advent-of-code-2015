package eu.happycoders.adventofcode2015.day23;

import java.util.List;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>The CPU emulator.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class CpuEmulator {

  private final List<Instruction> instructions;

  private final Register registerA = new Register();
  private final Register registerB = new Register();

  CpuEmulator(List<Instruction> instructions) {
    this.instructions = instructions;
  }

  void run() {
    int programCounter = 0;
    while (programCounter < instructions.size()) {
      Instruction instruction = instructions.get(programCounter);
      System.out.println("programCounter = " + programCounter + ", instruction = " + instruction);
      if (instruction instanceof RegisterModificationInstruction) {
        processRegisterModificationInstruction((RegisterModificationInstruction) instruction);
        programCounter++;
      } else if (instruction instanceof JumpInstruction) {
        programCounter += ((JumpInstruction) instruction).offset();
      } else if (instruction instanceof ConditionalJumpInstruction) {
        int offset = evaluateConditionalJumpInstruction((ConditionalJumpInstruction) instruction);
        programCounter += offset;
      } else {
        // The program exits when it tries to run an instruction beyond the ones defined.
        break;
      }
    }
  }

  void setRegisterA(int value) {
    registerA.setValue(value);
  }

  int getRegisterA() {
    return registerA.getValue();
  }

  int getRegisterB() {
    return registerB.getValue();
  }

  private void processRegisterModificationInstruction(RegisterModificationInstruction instruction) {
    Register register = getRegister(instruction.registerName());
    instruction.apply(register);
    System.out.println("Register " + instruction.registerName() + " is now " + register.getValue());
  }

  private int evaluateConditionalJumpInstruction(ConditionalJumpInstruction instruction) {
    if (instruction.test(getRegister(instruction.registerName()))) {
      System.out.println("-> true");
      return instruction.offset();
    } else {
      System.out.println("-> false");
      return 1;
    }
  }

  private Register getRegister(RegisterName registerName) {
    switch (registerName) {
      case A:
        return registerA;
      case B:
        return registerB;
      default:
        throw new AssertionError("Unknown register");
    }
  }
}
