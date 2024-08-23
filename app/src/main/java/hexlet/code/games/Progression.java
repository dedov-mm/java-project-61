package hexlet.code.games;

import hexlet.code.Engine;
import org.apache.commons.lang3.StringUtils;

public class Progression {
    public static void play() {
        Engine.greet("What number is missing in the progression?");

        for (int i = 0; i < Engine.getRounds(); i++) {
            int randomStartNumber = Engine.getRandomNumber();
            int randomStepNumber = Engine.getRandomStepNumber();
            int randomMissingNumberPosition = Engine.getRandomMissingNumberPosition(Engine.getRowLength());
            int[] randomArray = new int[Engine.getRowLength()];
            int result = 0;

            Engine.fillRandomArray(randomArray, randomStartNumber, randomStepNumber);
            StringBuilder questionWithARowOfNumbers = new StringBuilder();
            Question question = getQuestion(randomArray,
                    randomMissingNumberPosition,
                    questionWithARowOfNumbers,
                    result);

            System.out.println("Question: " + question.getStringBuilder());
            String userAnswer = Engine.getUserAnswer();
            Engine.printUserAnswer(userAnswer);
            if (StringUtils.isNumeric(userAnswer) && Integer.parseInt(userAnswer) == question.getResult()) {
                Engine.printMessageIfUserAnswerCorrect();
            } else {
                Engine.printMessageIfUserAnswerWrong(userAnswer, question.getResult());
                return;
            }
        }
        Engine.printCongratulations();
    }

    public static Question getQuestion(int[] randomArray,
                                       int randomMissingNumberPosition,
                                       StringBuilder questionWithARowOfNumbers,
                                       int result) {

        for (int k = 0; k < randomArray.length; k++) {
            if (randomArray[k] == randomArray[randomMissingNumberPosition]) {
                result = randomArray[k];
                questionWithARowOfNumbers.append(".. ");
                continue;
            }
            questionWithARowOfNumbers.append(randomArray[k]);
            if (k < randomArray.length - 1) {
                questionWithARowOfNumbers.append(" ");
            }
        }
        return new Question(questionWithARowOfNumbers, result);
    }
}

class Question {
    private final StringBuilder stringBuilder;
    private final int resultNumber;

    Question(StringBuilder sb, int result) {
        this.stringBuilder = sb;
        this.resultNumber = result;
    }

    public int getResult() {
        return resultNumber;
    }

    public StringBuilder getStringBuilder() {
        return stringBuilder;
    }
}
