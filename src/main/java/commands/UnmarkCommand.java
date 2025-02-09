package commands;

import controller.Ui;
import datastructure.TaskList;
import exception.InvalidInputException;

/**
 * {@code UnmarkCommand} class responsible for marking a task incomplete
 */
public class UnmarkCommand extends AbstractCommand {
    private final int id;

    /**
     * Constructs a {@code UnmarkCommand} class with id of Task
     *
     * @param id Id of Task to be unmarked
     */
    public UnmarkCommand(int id) {
        this.id = id;
    }

    /**
     * Execute the command by unmarking the task in task list
     * then having user interface print it
     *
     * @param taskList task list that contains all the task
     * @param ui       user interface that will facilitate printing
     * @throws InvalidInputException if input is invalid or in wrong format
     */
    @Override
    public void execute(TaskList taskList, Ui ui) throws InvalidInputException {
        ui.showTaskMessage(taskList.unmarked(id));
    }
}
