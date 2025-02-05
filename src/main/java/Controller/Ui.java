package Controller;

import java.util.Scanner;

public class Ui {
    private static final String LINE_BREAK = "\n__________________________________________\n";
    private final Scanner scanner;

    public Ui() {
        this.scanner = new Scanner(System.in);
    }

    public String readCommand() {
        return scanner.nextLine().trim();
    }
    public void showWelcomeMessage() {
        String asciiArt = " ____   ____   _ __  __ ____   __  _ \n" +
                "| _) \\ / () \\ | |\\ \\/ // () \\ |  \\| |\n" +
                "|____//__/\\__\\|_| |__|/__\\/__\\|_|\\__|";
        System.out.println(asciiArt);
        System.out.println(LINE_BREAK + "Hello I'm Daiyan What can I do for you?" + LINE_BREAK);
        System.out.print("How may I assist you commander?" + LINE_BREAK);
    }
    public void showGoodbyeMessage() {
        System.out.println("Bye, hope to see you again Commander." + LINE_BREAK);
    }
    public void showTaskMessage(String message){
        System.out.println(message + LINE_BREAK);
    }
    public void showErrorMessage(String message) {
        System.out.println(message + LINE_BREAK);
    }
}
