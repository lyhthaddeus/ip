package Commands;

import DataStructure.TaskList;
import Controller.Ui;
import Exception.InvalidInputException;

public abstract class AbstractCommand {
    public abstract void execute(TaskList taskList, Ui ui) throws InvalidInputException;

    public boolean isExit() {
        return false;
    }
}
