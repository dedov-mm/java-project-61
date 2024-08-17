package hexlet.code.games;

import hexlet.code.Engine;
import static hexlet.code.Engine.random;

public class GCD {
    public static void play() {
        Engine.greet("Find the greatest common divisor of given numbers.");

        for (int i = 0; i < Engine.rounds; i++) {
            int randomNumber1 = Engine.getRandomNumber();
            int randomNumber2 = Engine.getRandomNumber();

            System.out.println("Question: " + randomNumber1 + " " + randomNumber2);
            String userAnswer = Engine.scanner.next();
            System.out.println("Your answer: " + userAnswer);

            while (randomNumber1 > 0 && randomNumber2 > 0) {
                if (randomNumber1 >= randomNumber2) {
                    randomNumber1 = randomNumber1 % randomNumber2;
                } else {
                    randomNumber2 = randomNumber2 % randomNumber1;
                }
            }
            int result = Math.max(randomNumber1, randomNumber2);

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
