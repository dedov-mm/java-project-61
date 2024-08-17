package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;

public class App {
    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet\n2 - Even\n3 - Calc\n4 - GCD\n0 - Exit");
        String userChoice = Engine.scanner.next();
        System.out.println("Your choice: " + userChoice);
        switch (userChoice) {
            case "1" -> {
                Cli.start();
            }
            case "2" -> {
                Even.play();
            }
            case "3" -> {
                Calc.play();
            }
            case "4" -> {
                GCD.play();
            }
            case "0" -> {
                return;
            }
            default -> {
                return;
            }
        }
        Engine.scanner.close();
    }
}
