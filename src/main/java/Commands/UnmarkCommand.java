package Commands;

import Controller.Ui;
import DataStructure.TaskList;
import Exception.InvalidInputException;

public class UnmarkCommand extends AbstractCommand {
    private final int id;

    public UnmarkCommand(int id) {
        this.id = id;
    }

    @Override
    public void execute(TaskList taskList, Ui ui) throws InvalidInputException {
        ui.showTaskMessage(taskList.mark(id));
    }
}
