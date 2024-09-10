package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final int ROUNDS = 3;

    public static void run(String description, String[][] generatedRoundData) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        var userName = scanner.next();
        System.out.println("Hello, " + userName + "!");
        System.out.println(description);

        for (var value : generatedRoundData) {
            var question = value[0];
            var answer = value[1];
            System.out.println("Question: " + question);
            var userAnswer = scanner.next();
            System.out.println("Your answer: " + userAnswer);

            if (answer.equals(userAnswer)) {
                System.out.println("Correct!");
            } else {
                System.out.println(userAnswer
                        + " is wrong answer ;(. Correct answer was '"
                        + answer
                        + "'.\nLet's try again, "
                        + userName
                        + "!");
                return;
            }
        }

        System.out.println("Congratulations, " + userName + "!");
    }
}
