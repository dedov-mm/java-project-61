package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Engine {
    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();
    public static int minRandomNumber = 1;
    public static int maxRandomNumber = 100;
    public static int minRandomStepNumber = 2;
    public static int maxRandomStepNumber = 4;
    public static int rounds = 3;
    public static String userName;

    public static int getRandomNumber() {
        return random.nextInt(maxRandomNumber - minRandomNumber + 1) + minRandomNumber;
    }

    public static int getRandomStepNumber() {
        return random.nextInt(maxRandomStepNumber - minRandomStepNumber + 1) + minRandomStepNumber;
    }

    public static int getRandomMissingNumberPosition(int range) {
        return random.nextInt(range);
    }

    public static void greet(String gameCondition) {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        userName = scanner.next();
        System.out.println("Hello, " + userName + "!");
        System.out.println(gameCondition);
    }

    public static int getGreatestCommonDivisor(int randomNumber1, int randomNumber2) {
        while (randomNumber1 > 0 && randomNumber2 > 0) {
            if (randomNumber1 >= randomNumber2) {
                randomNumber1 = randomNumber1 % randomNumber2;
            } else {
                randomNumber2 = randomNumber2 % randomNumber1;
            }
        }
        return Math.max(randomNumber1, randomNumber2);
    }

    public static void fillRandomArray(int[] randomArray, int randomStartNumber, int randomStepNumber) {
        for (int j = 0; j < randomArray.length; j++) {
            randomArray[j] = randomStartNumber;
            randomStartNumber = randomStartNumber + randomStepNumber;
        }
    }

    public static boolean isPrime(int number) {
        if (number == 2) {
            return true;
        }
        for (int i = 2; i <= number - 1; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void printCongratulations() {
        System.out.println("Congratulations, " + Engine.userName + "!");
    }

    public static String getUserAnswer() {
        return Engine.scanner.next();
    }

    public static void printUserAnswer(String userAnswer) {
        System.out.println("Your answer: " + userAnswer);
    }

    public static void printMessageIfUserAnswerCorrect() {
        System.out.println("Correct!");
    }

    public static void printMessageIfUserAnswerWrong(String userAnswer, int result) {
        System.out.println(userAnswer
                + " is wrong answer ;(. Correct answer was '"
                + result
                + "'.\nLet's try again, "
                + userName
                + "!");
    }

    public static void printMessageIfUserAnswerWrong(String userAnswer, String result) {
        System.out.println(userAnswer
                + " is wrong answer ;(. Correct answer was '"
                + result
                + "'.\nLet's try again, "
                + userName
                + "!");
    }
}
