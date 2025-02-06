package app;

import Commands.AbstractCommand;
import Controller.Parser;
import Controller.Storage;
import Controller.Ui;
import DataStructure.TaskList;
import Exception.InvalidInputException;

/**
 * The main class for the Daiyan task management application.
 * It initializes and manages the core components such as storage, task list, and user interface.
 * The application runs in a loop, continuously processing user commands until an exit command is issued.
 */
public class Daiyan {

  private final Storage storage;
  private TaskList taskList;
  private final Ui ui;

    /**
     * Constructs a new instance of the Daiyan application.
     * It initializes the storage system, user interface, and loads tasks from the specified file.
     *
     * @param filePath The file path where task data is stored.
     */
    public Daiyan(String filePath) {
        this.ui = new Ui();
        this.storage = new Storage(filePath);
        try {
            this.taskList = storage.load();
        } catch (InvalidInputException e) {
            ui.showErrorMessage("Sorry Commander, I was unable to fetch our old logs");
            taskList = new TaskList();
        }
    }

    /**
     * Starts the application, continuously processing user commands until an exit command is received.
     */
    public void run() {
        Parser parser = new Parser(storage);

        this.ui.showWelcomeMessage();
        ;
        boolean isRunning = true;
        while (isRunning) {
            String input = ui.readCommand();
            try {
                AbstractCommand command = parser.parse(input);
                command.execute(this.taskList, this.ui);
                if (command.isExit()) {
                    isRunning = false;
                }
            } catch (InvalidInputException e) {
                ui.showErrorMessage(e.getMessage());
            }
        }
    }

    /**
     * The main entry point of the Daiyan application.
     * It initializes and runs the application with the specified storage file path.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        new Daiyan("./data/storage.txt").run();
    }
}
