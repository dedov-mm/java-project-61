package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Even {
    public static void play() {
        Engine.greet("Answer 'yes' if the number is even, otherwise answer 'no'.");

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
        if (number % 2 == 0) {
            return "yes";
        } else {
            return "no";
        }
    }
}
