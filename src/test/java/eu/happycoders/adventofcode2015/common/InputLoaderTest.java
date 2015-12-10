package eu.happycoders.adventofcode2015.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.UncheckedIOException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;

class InputLoaderTest {

  @Test
  void givenANonExistingFile_loadInput_throwsNoSuchFileException() {
    String fileName = "does-not-exist.txt";

    ThrowableAssert.ThrowingCallable invocation = () -> InputLoader.loadInput(fileName);

    assertThatThrownBy(invocation)
        .isInstanceOf(UncheckedIOException.class)
        .hasCauseInstanceOf(NoSuchFileException.class);
  }

  @Test
  void givenAnExistingFile_loadFile_returnsTheFileContents() {
    Path path = Paths.get("src/test/resources/test.txt");

    String contents = InputLoader.loadFile(path);

    assertThat(contents).isEqualToNormalizingNewlines("fizz\nbuzz");
  }
}
