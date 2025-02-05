package Commands;

import TaskObjects.AbstractTask;
import Controller.Ui;
import DataStructure.TaskList;

public class AddCommand extends AbstractCommand {
    private final AbstractTask task;

    public AddCommand(AbstractTask task) {
        this.task = task;
    }

    @Override
    public void execute(TaskList taskList, Ui ui) {
        String message = taskList.add(this.task);
        ui.showTaskMessage(message);
    }
}
