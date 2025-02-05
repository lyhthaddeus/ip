package Interface;

import DataStructure.TaskList;
import Exception.InvalidInputException;
import Controller.Ui;

public interface ICommand {
    public void execute(TaskList taskList, Ui ui) throws InvalidInputException;
    public boolean isExit();
}
