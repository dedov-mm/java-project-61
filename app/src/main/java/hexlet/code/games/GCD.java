package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class GCD {
    public static void runGame() {
        final var description = "Find the greatest common divisor of given numbers.";
        String[][] roundsData = new String[Engine.ROUNDS][2];

        for (int i = 0; i < Engine.ROUNDS; i++) {
            roundsData[i] = generateRoundData();
        }

        Engine.run(description, roundsData);
    }

    private static String[] generateRoundData() {
        final var min = 1;
        final var max = 20;

        var number1 = Utils.generateNumber(min, max);
        var number2 = Utils.generateNumber(min, max);

        var question = number1 + " " + number2;
        var answer = Integer.toString(gcd(number1, number2));

        return new String[] {question, answer};
    }

    private static int gcd(int randomNumber1, int randomNumber2) {
        while (randomNumber1 > 0 && randomNumber2 > 0) {
            if (randomNumber1 >= randomNumber2) {
                randomNumber1 = randomNumber1 % randomNumber2;
            } else {
                randomNumber2 = randomNumber2 % randomNumber1;
            }
        }
        return Math.max(randomNumber1, randomNumber2);
    }
}
