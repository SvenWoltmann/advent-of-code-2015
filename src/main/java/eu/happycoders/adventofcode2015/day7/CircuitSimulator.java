package eu.happycoders.adventofcode2015.day7;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Advent of Code 2015 – Object-Oriented Solutions in Java.
 *
 * <p>Simulator for the circuit.
 *
 * @author <a href="mailto:sven@happycoders.eu">Sven Woltmann</a>
 */
class CircuitSimulator {

  private final Map<String, WireSource> destinationWireIdToWireSource;

  CircuitSimulator(List<Instruction> instructions) {
    destinationWireIdToWireSource =
        instructions.stream()
            .collect(Collectors.toMap(Instruction::destinationWireId, Instruction::wireSource));

    wireUpAllWires();
  }

  void putInstruction(Instruction instruction) {
    destinationWireIdToWireSource.put(instruction.destinationWireId(), instruction.wireSource());

    // We only need to wire up the Wire with the instruction's destination wire ID.
    // But we cannot easily find it. To keep is simple, just re-wire everything.
    wireUpAllWires();
  }

  private void wireUpAllWires() {
    for (WireSource wireSource : destinationWireIdToWireSource.values()) {
      wireUpWireSource(wireSource);
    }
  }

  private void wireUpWireSource(WireSource wireSource) {
    if (wireSource instanceof BinaryGate) {
      wireUpGateInputIfWire(((BinaryGate) wireSource).gateInput1);
      wireUpGateInputIfWire(((BinaryGate) wireSource).gateInput2);
    }
    if (wireSource instanceof UnaryGate) {
      wireUpGateInputIfWire(((UnaryGate) wireSource).gateInput);
    }
    if (wireSource instanceof Wire) {
      wireUpWire((Wire) wireSource);
    }
  }

  private void wireUpGateInputIfWire(GateInput gateInput) {
    if (gateInput instanceof Wire) {
      wireUpWire((Wire) gateInput);
    }
  }

  private void wireUpWire(Wire wire) {
    wire.setWireSource(destinationWireIdToWireSource.get(wire.id()));
  }

  int getSignalOnWire(String wireId) {
    WireSource wireSource = destinationWireIdToWireSource.get(wireId);
    return wireSource.getSignal();
  }

  void resetAllWires() {
    for (WireSource wireSource : destinationWireIdToWireSource.values()) {
      wireSource.reset();
    }
  }
}
