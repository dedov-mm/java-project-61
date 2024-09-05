package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Prime {
    public static void play() {
        Engine.greet("Answer 'yes' if given number is prime. Otherwise answer 'no'.");

        for (int i = 0; i < Engine.getRounds(); i++) {
            var generatedRoundData = generateRoundData();
            var result = Engine.check(generatedRoundData);

            if (!result) {
                return;
            }
        }
        Engine.printCongratulations();
    }

    private static String[] generateRoundData() {
        final var min = 1;
        final var max = 100;

        var number = Utils.generateNumber(min, max);

        var question = Integer.toString(number);
        var answer = calculate(number);

        return new String[] {question, answer};
    }

    private static String calculate(int number) {
        if (number == 2) {
            return "yes";
        }

        for (int i = 2; i <= number - 1; i++) {
            if (number % i == 0) {
                return "no";
            }
        }
        return "yes";
    }
}
