package eu.happycoders.adventofcode2015.day23;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CpuEmulatorTest {

  @Test
  void givenACpuWithTestInstructions_run_registerValuesAre2and0() {
    CpuEmulator cpuEmulator = new CpuEmulator(TestInputs.TEST_INSTRUCTIONS);

    cpuEmulator.run();

    assertThat(cpuEmulator.getRegisterA()).isEqualTo(2);
    assertThat(cpuEmulator.getRegisterB()).isZero();
  }

  @Test
  void givenACpuWithExtendedTestInstructions_run_registerValuesAre12and1() {
    CpuEmulator cpuEmulator = new CpuEmulator(TestInputs.TEST_INSTRUCTIONS_EXTENDED);

    cpuEmulator.run();

    assertThat(cpuEmulator.getRegisterA()).isEqualTo(12);
    assertThat(cpuEmulator.getRegisterB()).isEqualTo(1);
  }

  @Test
  void givenACpuWithExtendedTestInstructionsAndRegisterASetTo1_run_registerValuesAre1and0() {
    CpuEmulator cpuEmulator = new CpuEmulator(TestInputs.TEST_INSTRUCTIONS_EXTENDED);
    cpuEmulator.setRegisterA(1);

    cpuEmulator.run();

    assertThat(cpuEmulator.getRegisterA()).isEqualTo(1);
    assertThat(cpuEmulator.getRegisterB()).isZero();
  }
}
