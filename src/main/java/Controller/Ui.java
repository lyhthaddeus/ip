package Controller;

import java.util.Scanner;

/**
 * {@code Ui} class responsible to reading Sys in and writing to Sys out.
 * Handles printing messages as well as error messages
 */
public class Ui {
    private static final String LINE_BREAK = "\n__________________________________________\n";
    private final Scanner scanner;

    /**
     * Construct an instance of {@code Ui} class with a scanner
     */
    public Ui() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Reads the user input and trims it to a string
     *
     * @return Raw String user input trimmed
     */
    public String readCommand() {
        return scanner.nextLine().trim();
    }

    /**
     * Prints standard welcome message when starting the app
     */
    public void showWelcomeMessage() {
        String asciiArt = " ____   ____   _ __  __ ____   __  _ \n" +
                "| _) \\ / () \\ | |\\ \\/ // () \\ |  \\| |\n" +
                "|____//__/\\__\\|_| |__|/__\\/__\\|_|\\__|";
        System.out.println(asciiArt);
        System.out.println(LINE_BREAK + "Hello I'm Daiyan What can I do for you?" + LINE_BREAK);
        System.out.print("How may I assist you commander?" + LINE_BREAK);
    }

    /**
     * prints standard goodbye message when exiting the app
     */
    public void showGoodbyeMessage() {
        System.out.println("Bye, hope to see you again Commander." + LINE_BREAK);
    }

    /**
     * Prints message from task to System out
     *
     * @param message Message from task
     */
    public void showTaskMessage(String message) {
        System.out.println(message + LINE_BREAK);
    }

    /**
     * Prints the error message to System out
     *
     * @param message Error message to be printed
     */
    public void showErrorMessage(String message) {
        System.out.println(message + LINE_BREAK);
    }
}
