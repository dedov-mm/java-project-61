package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Prime {
    public static void runGame() {
        final var description = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
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
        var answer = isPrime(number) ? "yes" : "no";

        return new String[] {question, answer};
    }

    private static boolean isPrime(int number) {
        if (number == 2) {
            return true;
        }

        for (int i = 2; i <= number - 1; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
