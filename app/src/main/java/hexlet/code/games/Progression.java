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
        final var amountOfNumbers = 10;
        final var minStartNumber = 1;
        final var maxStartNumber = 100;
        final var minStepNumber = 2;
        final var maxStepNumber = 5;
        final var minMissingPosition = 1;
        final var maxMissingPosition = amountOfNumbers;

        final var startNumber = Utils.generateNumber(minStartNumber, maxStartNumber);
        final var stepNumber = Utils.generateNumber(minStepNumber, maxStepNumber);
        final var missingPosition = Utils.generateNumber(minMissingPosition, maxMissingPosition);

        var questionAndAnswer = calculate(amountOfNumbers, startNumber, stepNumber, missingPosition);

        return questionAndAnswer;
    }

    private static String[] calculate(int amountOfNumbers, int startNumber, int stepNumber, int missingPosition) {
        var numberSeries = new int[amountOfNumbers];
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

