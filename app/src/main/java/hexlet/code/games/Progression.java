package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Progression {
    public static void play() {
        Engine.greet("What number is missing in the progression?");

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
        var startNumber = Utils.generateNumber(1, 100);
        var stepNumber = Utils.generateNumber(2, 5);
        var missingPosition = Utils.generateNumber(1, 10);
        var numberSeries = new int[10];

        var questionAndAnswer = calculate(numberSeries, startNumber, stepNumber, missingPosition);

        return questionAndAnswer;
    }

    private static String[] calculate(int[] numberSeries, int startNumber, int stepNumber, int missingPosition) {
        var question = new StringBuilder();
        var answer = 0;

        for (int j = 0; j < numberSeries.length; j++) {
            numberSeries[j] = startNumber;
            startNumber = startNumber + stepNumber;
        }

        for (int k = 0; k < numberSeries.length; k++) {
            if (numberSeries[k] == numberSeries[missingPosition - 1]) {
                answer = numberSeries[k];
                question.append(".. ");
                continue;
            }
            question.append(numberSeries[k]);
            if (k < numberSeries.length - 1) {
                question.append(" ");
            }
        }
        return new String[] {question.toString(), Integer.toString(answer)};
    }

}

