package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final int ROUNDS = 3;
    private static String userName;
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void greet(String gameCondition) {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        userName = SCANNER.next();
        System.out.println("Hello, " + userName + "!");
        System.out.println(gameCondition);
    }

    public static void printCongratulations() {
        System.out.println("Congratulations, " + userName + "!");
    }

    public static void printMessageIfUserAnswerCorrect() {
        System.out.println("Correct!");
    }

    public static void printMessageIfUserAnswerWrong(String userAnswer, String result) {
        System.out.println(userAnswer
                + " is wrong answer ;(. Correct answer was '"
                + result
                + "'.\nLet's try again, "
                + userName
                + "!");
    }

    public static boolean check(String[] generatedRoundData) {
        var question = generatedRoundData[0];
        var answer = generatedRoundData[1];

        System.out.println("Question: " + question);
        var userAnswer = SCANNER.next();
        System.out.println("Your answer: " + userAnswer);

        if (answer.equals(userAnswer)) {
            printMessageIfUserAnswerCorrect();
            return true;
        } else {
            printMessageIfUserAnswerWrong(userAnswer, answer);
            return false;
        }
    }

    public static void run(String description, String[][] generatedRoundData) {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        userName = SCANNER.next();
        System.out.println("Hello, " + userName + "!");
        System.out.println(description);

        for (int i = 0; i < ROUNDS; i++) {
            System.out.println("Question: " + generatedRoundData[i][0]);
            var userAnswer = SCANNER.next();
            System.out.println("Your answer: " + userAnswer);
            var answer = generatedRoundData[i][1];

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
