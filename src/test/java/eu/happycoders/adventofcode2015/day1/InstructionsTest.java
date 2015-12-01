package eu.happycoders.adventofcode2015.day1;

import static eu.happycoders.adventofcode2015.day1.Direction.DOWN;
import static eu.happycoders.adventofcode2015.day1.Direction.UP;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;

class InstructionsTest {

  @Test
  void
      givenInstructionsUpUpDown_hasNextAndNextReturnThreeTimesTrueAndDirectionsThenFalseAndException() {
    Instructions instructions = new Instructions("(()");

    assertThat(instructions.hasNext()).isTrue();
    assertThat(instructions.next()).isEqualTo(UP);

    assertThat(instructions.hasNext()).isTrue();
    assertThat(instructions.next()).isEqualTo(UP);

    assertThat(instructions.hasNext()).isTrue();
    assertThat(instructions.next()).isEqualTo(DOWN);

    assertThat(instructions.hasNext()).isFalse();
    assertThatThrownBy(instructions::next).isInstanceOf(NoSuchElementException.class);
  }
}
