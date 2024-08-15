package hexlet.code.games;

import hexlet.code.Engine;
import java.util.List;
import java.util.function.IntBinaryOperator;
import static hexlet.code.Engine.random;

public class Calc {
    private record Operation(String name, IntBinaryOperator operation) { }
    private static List<Operation> operations =
            List.of(new Operation("+", (i1, i2) -> i1 + i2),
                    new Operation("-", (i1, i2) -> i1 - i2),
                    new Operation("*", (i1, i2) -> i1 * i2),
                    new Operation("/", (i1, i2) -> i1 / i2));

    public static void play() {
        Engine.greet("What is the result of the expression?");

        for (int i = 0; i < Engine.rounds; i++) {
            int randomNumber1 = Engine.getRandomNumber();
            int randomNumber2 = Engine.getRandomNumber();
            Operation randomOperation = operations.get(random.nextInt(operations.size()));
            int result = randomOperation.operation().applyAsInt(randomNumber1, randomNumber2);

            System.out.println("Question: " + randomNumber1 + " " + randomOperation.name + " " + randomNumber2);
            String userAnswer = Engine.scanner.next();
            System.out.println("Your answer: " + userAnswer);

            if (Integer.parseInt(userAnswer) == result) {
                System.out.println("Correct!");
            } else {
                System.out.println(userAnswer
                        + " is wrong answer ;(. Correct answer was "
                        + result
                        + "\nLet's try again, "
                        + Engine.userName
                        + "!");
                return;
            }
        }
        Engine.printCongratulations();
    }
}
