package hexlet.code.games;

import hexlet.code.Engine;

public class Prime {
    public static void play() {
        Engine.greet("Answer 'yes' if given number is prime. Otherwise answer 'no'.");

        for (int i = 0; i < Engine.getRounds(); i++) {
            int randomNumber = Engine.getRandomNumber();
            boolean result = Engine.isPrime(randomNumber);

            System.out.println("Question: " + randomNumber);
            String userAnswer = Engine.getUserAnswer();
            Engine.printUserAnswer(userAnswer);

            if (result && userAnswer.equals("yes") || !result && userAnswer.equals("no")) {
                Engine.printMessageIfUserAnswerCorrect();
            } else if (result) {
                Engine.printMessageIfUserAnswerWrong(userAnswer, "yes");
                return;
            } else if (!result) {
                Engine.printMessageIfUserAnswerWrong(userAnswer, "no");
                return;
            }
        }
        Engine.printCongratulations();
    }
}
