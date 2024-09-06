package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Progression {
    public static void runGame() {
        final var description = "What number is missing in the progression?";
        String[][] roundsData = new String[Engine.ROUNDS][2];

        for (int i = 0; i < Engine.ROUNDS; i++) {
            roundsData[i] = generateRoundData();
        }

        Engine.run(description, roundsData);
    }

    private static String[] generateRoundData() {
        final var minStartNumber = 1;
        final var maxStartNumber = 100;
        final var minStepNumber = 2;
        final var maxStepNumber = 5;
        final var minMissingPosition = 0;
        final var maxMissingPosition = 9;

        final var first = Utils.generateNumber(minStartNumber, maxStartNumber);
        final var step = Utils.generateNumber(minStepNumber, maxStepNumber);
        final var length = 10;
        final var missingPosition = Utils.generateNumber(minMissingPosition, maxMissingPosition);

        var progression = makeProgression(first, step, length);
        String answer = progression[missingPosition];
        progression[missingPosition] = "..";
        String question = String.join(" ", progression);

        return new String[] {question, answer};
    }

    private static String[] makeProgression(int first, int step, int length) {
        String[] progression = new String[length];

        for (int i = 0; i < length; i++) {
            progression[i] = Integer.toString(first + i * step);
        }

        return progression;
    }

}

