package Commands;

import Controller.Ui;
import DataStructure.TaskList;
import Exception.InvalidInputException;

public class MarkCommand extends AbstractCommand {
    private final int id;

    public MarkCommand(int id) {
        this.id = id;
    }

    @Override
    public void execute(TaskList taskList, Ui ui) throws InvalidInputException {
        ui.showTaskMessage(taskList.mark(id));
    }
}
