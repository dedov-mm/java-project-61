package hexlet.code.games;

import hexlet.code.Engine;

public class GCD {
    public static void play() {
        Engine.greet("Find the greatest common divisor of given numbers.");

        for (int i = 0; i < Engine.rounds; i++) {
            int randomNumber1 = Engine.getRandomNumber();
            int randomNumber2 = Engine.getRandomNumber();
            int result = Engine.getGreatestCommonDivisor(randomNumber1, randomNumber2);

            System.out.println("Question: " + randomNumber1 + " " + randomNumber2);
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
