package Commands;

import Controller.Ui;
import DataStructure.TaskList;
import TaskObjects.AbstractTask;
import Exception.InvalidInputException;

public class DeleteCommand extends AbstractCommand {
    private final int taskId;

    public DeleteCommand(int taskId) {
        this.taskId = taskId;
    }
    @Override
    public void execute(TaskList taskList, Ui ui) throws InvalidInputException {
        String message = taskList.delete(this.taskId);
        ui.showTaskMessage(message);
    }
}
