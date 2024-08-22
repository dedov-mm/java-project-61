package hexlet.code;

import static hexlet.code.Engine.scanner;

public class Cli {

    public static void start() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");
    }


}
