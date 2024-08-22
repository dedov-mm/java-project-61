package hexlet.code.games;

import hexlet.code.Engine;
import java.util.List;
import java.util.function.IntBinaryOperator;

public class Calc {
    private record Operation(String name, IntBinaryOperator operation) { }
    private static List<Operation> operations =
            List.of(new Operation("+", (i1, i2) -> i1 + i2),
                    new Operation("-", (i1, i2) -> i1 - i2),
                    new Operation("*", (i1, i2) -> i1 * i2));

    public static void play() {
        Engine.greet("What is the result of the expression?");

        for (int i = 0; i < Engine.getRounds(); i++) {
            int randomNumber1 = Engine.getRandomNumber();
            int randomNumber2 = Engine.getRandomNumber();
            Operation randomOperation = operations.get(Engine.getRandom().nextInt(operations.size()));
            int result = randomOperation.operation().applyAsInt(randomNumber1, randomNumber2);

            System.out.println("Question: " + randomNumber1 + " " + randomOperation.name + " " + randomNumber2);
            String userAnswer = Engine.getUserAnswer();
            Engine.printUserAnswer(userAnswer);

            if (Integer.parseInt(userAnswer) == result) {
                Engine.printMessageIfUserAnswerCorrect();
            } else {
                Engine.printMessageIfUserAnswerWrong(userAnswer, result);
                return;
            }
        }
        Engine.printCongratulations();
    }
}
