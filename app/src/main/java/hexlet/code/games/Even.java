package hexlet.code.games;

import hexlet.code.Engine;

public class Even {
    public static void play() {
        Engine.greet("Answer 'yes' if the number is even, otherwise answer 'no'.");

        for (int i = 0; i < Engine.rounds; i++) {
            int randomNumber = Engine.getRandomNumber();

            System.out.println("Question: " + randomNumber);
            String userAnswer = Engine.getUserAnswer();
            Engine.printUserAnswer(userAnswer);

            if (randomNumber % 2 == 0 && userAnswer.equals("yes") || randomNumber % 2 != 0 && userAnswer.equals("no")) {
                Engine.printMessageIfUserAnswerCorrect();
            } else if (randomNumber % 2 != 0) {
                System.out.println(userAnswer
                        + " is wrong answer ;(. Correct answer was 'no'.\n"
                        + "Let's try again, "
                        + Engine.userName
                        + "!");
                return;
            } else if (randomNumber % 2 == 0) {
                System.out.println(userAnswer
                        + " is wrong answer ;(. Correct answer was 'yes'.\n"
                        + "Let's try again, "
                        + Engine.userName
                        + "!");
                return;
            }
        }
        Engine.printCongratulations();
    }
}
