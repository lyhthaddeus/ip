package Commands;

import Controller.Storage;
import Controller.Ui;
import DataStructure.TaskList;
import Exception.InvalidInputException;
import TaskObjects.AbstractTask;

public class ExitCommand extends AbstractCommand{
    private Storage storage;
    public ExitCommand(Storage storage) {
        this.storage = storage;
    }
    @Override
    public void execute(TaskList taskList, Ui ui) throws InvalidInputException {
        storage.save(taskList.getlist());
        ui.showGoodbyeMessage();
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
