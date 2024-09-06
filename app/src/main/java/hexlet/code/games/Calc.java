package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Calc {
    public static void runGame() {
        final var description = "What is the result of the expression?";
        String[][] roundsData = new String[Engine.ROUNDS][2];

        for (int i = 0; i < Engine.ROUNDS; i++) {
            roundsData[i] = generateRoundData();
        }

        Engine.run(description, roundsData);
    }

    private static String[] generateRoundData() {
        final var min = 1;
        final var max = 20;
        final char[] operators = {'+', '-', '*'};

        var number1 = Utils.generateNumber(min, max);
        var number2 = Utils.generateNumber(min, max);

        var indexOperator = Utils.generateNumber(0, operators.length - 1);
        var operator = operators[indexOperator];

        var question = number1 + " " + operator + " " + number2;
        var answer = Integer.toString(calculate(operator, number1, number2));

        return new String[] {question, answer};
    }

    private static int calculate(char operator, int number1, int number2) {
        switch (operator) {
            case '+' -> {
                return number1 + number2;
            }
            case '-' -> {
                return number1 - number2;
            }
            case '*' -> {
                return number1 * number2;
            }
            default -> {
                return 0;
            }
        }
    }
}
