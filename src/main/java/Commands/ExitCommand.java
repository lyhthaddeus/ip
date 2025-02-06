package Commands;

import Controller.Storage;
import Controller.Ui;
import DataStructure.TaskList;
import Exception.InvalidInputException;
import TaskObjects.AbstractTask;

/**
 * {@code ExitCommand} class responsible for exiting the program
 */
public class ExitCommand extends AbstractCommand {
    private final Storage storage;

    /**
     * Constructs a {@code ExitCommand} instance with {@code Storage} instance where
     * data will be saved to
     *
     * @param storage Storage class that will handle saving of data
     */
    public ExitCommand(Storage storage) {
        this.storage = storage;
    }

    /**
     * Executes the command by saving the calling storage class to save the
     * data then call user interface to print goodbye message
     *
     * @param taskList task list that contains all the task
     * @param ui       user interface that will facilitate printing
     * @throws InvalidInputException if input is invalid or in wrong format
     */
    @Override
    public void execute(TaskList taskList, Ui ui) throws InvalidInputException {
        storage.save(taskList.getlist());
        ui.showGoodbyeMessage();
    }

    /**
     * States that this is an exit code
     *
     * @return {@code true}
     */
    @Override
    public boolean isExit() {
        return true;
    }
}
