package hexlet.code;

import java.util.Random;

public class Even {
    static Random random = new Random();
    static int minRandomNumber = 1;
    static int maxRandomNumber = 100;

    public static void play() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = App.scanner.next();
        System.out.println("Hello, " + userName + "!");
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        for (int i = 0; i < 3; i++) {
            int randomNumber = random.nextInt(maxRandomNumber - minRandomNumber + 1) + minRandomNumber;
            System.out.println("Question: " + randomNumber);
            String userAnswer = App.scanner.next();
            System.out.println("Your answer: " + userAnswer);
            if (randomNumber % 2 == 0 && userAnswer.equals("yes") || randomNumber % 2 != 0 && userAnswer.equals("no")) {
                System.out.println("Correct!");
            } else if (randomNumber % 2 != 0) {
                System.out.println(userAnswer
                        + " is wrong answer ;(. Correct answer was 'no'.\n"
                        + "Let's try again, "
                        + userName
                        + "!");
                return;
            } else if (randomNumber % 2 == 0) {
                System.out.println(userAnswer
                        + " is wrong answer ;(. Correct answer was 'yes'.\n"
                        + "Let's try again, "
                        + userName
                        + "!");
                return;
            }
        }
        System.out.println("Congratulations, " + userName + "!");
    }
}
