import Commands.AbstractCommand;
import Controller.Parser;
import Controller.Storage;
import Controller.Ui;
import DataStructure.TaskList;
import Exception.InvalidInputException;
import Exception.SyntaxException;

public class Daiyan {

  private final Storage storage;
  private TaskList taskList;
  private final Ui ui;

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

  public void run() {
    Parser parser = new Parser(storage);

    this.ui.showWelcomeMessage();;
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

  public static void main(String[] args) {
    new Daiyan("./data/storage.txt").run();
  }
}
