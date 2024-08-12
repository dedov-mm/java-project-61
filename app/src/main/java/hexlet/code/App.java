package hexlet.code;

import java.util.Scanner;

public class App {
    public static Scanner scanner = new Scanner(System.in);
    public static String username;

    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet\n2 - Even\n0 - Exit");
        String userChoice = scanner.next();
        System.out.println("Your choice: " + userChoice);
        switch (userChoice) {
            case "1" -> {
                Cli.start();
            }
            case "2" -> {
                Even.play();
            }
            case "0" -> {
                return;
            }
            default -> {
                return;
            }
        }
        scanner.close();
    }
}
