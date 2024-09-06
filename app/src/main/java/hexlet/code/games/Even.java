package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Even {
    public static void runGame() {
        final var description = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        String[][] roundsData = new String[Engine.ROUNDS][2];

        for (int i = 0; i < Engine.ROUNDS; i++) {
            roundsData[i] = generateRoundData();
        }

        Engine.run(description, roundsData);
    }

    private static String[] generateRoundData() {
        final var min = 1;
        final var max = 100;

        var number = Utils.generateNumber(min, max);

        var question = Integer.toString(number);
        var answer = isEven(number) ? "yes" : "no";

        return new String[] {question, answer};
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
