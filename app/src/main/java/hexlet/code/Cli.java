package hexlet.code;

public class Cli {

    public static void start() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = Engine.getScanner().next();
        System.out.println("Hello, " + userName + "!");
    }


}
