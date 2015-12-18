package eu.happycoders.adventofcode2015.day18;

class TestInputs {

  static final String TEST_INPUT =
      ".#.#.#\n" //
          + "...##.\n"
          + "#....#\n"
          + "..#...\n"
          + "#.#..#\n"
          + "####..\n";

  static final boolean[][] TEST_LIT_LIGHTS = createTestLitLights();

  private static boolean[][] createTestLitLights() {
    boolean[][] litLights = new boolean[6][6];

    litLights[0][1] = true;
    litLights[0][3] = true;
    litLights[0][5] = true;

    litLights[1][3] = true;
    litLights[1][4] = true;

    litLights[2][0] = true;
    litLights[2][5] = true;

    litLights[3][2] = true;

    litLights[4][0] = true;
    litLights[4][2] = true;
    litLights[4][5] = true;

    litLights[5][0] = true;
    litLights[5][1] = true;
    litLights[5][2] = true;
    litLights[5][3] = true;

    return litLights;
  }
}
