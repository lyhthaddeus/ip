package Commands;

import Controller.Ui;
import DataStructure.TaskList;
import Exception.InvalidInputException;

public class ListCommand extends AbstractCommand {

    @Override
    public void execute(TaskList taskList, Ui ui) throws InvalidInputException {
        ui.showTaskMessage(taskList.getTaskList());
    }
}
