package eu.happycoders.adventofcode2015.day7;

import static eu.happycoders.adventofcode2015.day7.TestInputs.TEST_INSTRUCTIONS;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CircuitSimulatorTest {

  public static Stream<Arguments> wire2AndExpectedValues() {
    return Stream.of(
        Arguments.of("d", 72),
        Arguments.of("e", 507),
        Arguments.of("f", 492),
        Arguments.of("g", 114),
        Arguments.of("h", 65412),
        Arguments.of("i", 65079),
        Arguments.of("x", 123),
        Arguments.of("y", 456));
  }

  @ParameterizedTest
  @MethodSource("wire2AndExpectedValues")
  void givenCircuitSimulatorWithTestInstructions_getSignalOnSpecifiedWire_returnsExpectedValue(
      String wireName, int expectedValue) {
    CircuitSimulator circuitSimulator = new CircuitSimulator(TEST_INSTRUCTIONS);

    int signal = circuitSimulator.getSignalOnWire(wireName);

    assertThat(signal).isEqualTo(expectedValue);
  }
}
