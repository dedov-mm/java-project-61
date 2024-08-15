package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Engine {
    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();
    public static int minRandomNumber = 1;
    public static int maxRandomNumber = 100;
    public static int rounds = 3;
    public static String userName;

    public static int getRandomNumber() {
        return random.nextInt(maxRandomNumber - minRandomNumber + 1) + minRandomNumber;
    }

    public static void greet(String gameCondition) {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        userName = scanner.next();
        System.out.println("Hello, " + userName + "!");
        System.out.println(gameCondition);
    }

    public static void printCongratulations() {
        System.out.println("Congratulations, " + Engine.userName + "!");
    }
}
