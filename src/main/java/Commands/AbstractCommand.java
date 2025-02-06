package Commands;

import DataStructure.TaskList;
import Controller.Ui;
import Exception.InvalidInputException;

/**
 * Abstract {@code AbstractCommand} class that encapsulate parent behaviour for all Commands
 */
public abstract class AbstractCommand {
    /**
     * Execution of task to be implemented
     *
     * @param taskList task list that contains all the task
     * @param ui       user interface that will facilitate printing
     * @throws InvalidInputException if input is invalid or in wrong format
     */
    public abstract void execute(TaskList taskList, Ui ui) throws InvalidInputException;

    /**
     * State whether this is an exit command or not
     *
     * @return {@code true} if command should terminate the program
     */
    public boolean isExit() {
        return false;
    }
}
