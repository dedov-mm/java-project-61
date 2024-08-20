package hexlet.code.games;

import hexlet.code.Engine;
import org.apache.commons.lang3.StringUtils;

public class Progression {
    public static void play() {
        Engine.greet("What number is missing in the progression?");

        for (int i = 0; i < Engine.rounds; i++) {
            int randomStartNumber = Engine.getRandomNumber();
            int randomStepNumber = Engine.getRandomStepNumber();
            int rowLength = 10;
            int randomMissingNumberPosition = Engine.getRandomMissingNumberPosition(rowLength);
            int[] randomArray = new int[rowLength];
            int result = 0;

            Engine.fillRandomArray(randomArray, randomStartNumber, randomStepNumber);
            StringBuilder questionWithARowOfNumbers = new StringBuilder();
            for (int k = 0; k < randomArray.length; k++) {
                if (randomArray[k] == randomArray[randomMissingNumberPosition]) {
                    result = randomArray[k];
                    questionWithARowOfNumbers.append(".. ");
                    continue;
                }
                questionWithARowOfNumbers.append(randomArray[k]);
                if (i < randomArray.length - 1) {
                    questionWithARowOfNumbers.append(" ");
                }
            }

            System.out.println("Question: " + questionWithARowOfNumbers);
            String userAnswer = Engine.getUserAnswer();
            Engine.printUserAnswer(userAnswer);

            if (StringUtils.isNumeric(userAnswer) && Integer.parseInt(userAnswer) == result) {
                Engine.printMessageIfUserAnswerCorrect();
            } else {
                Engine.printMessageIfUserAnswerWrong(userAnswer, result);
                return;
            }
        }
        Engine.printCongratulations();
    }
}
