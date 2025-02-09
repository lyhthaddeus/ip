package interfaces;

import datastructure.TaskList;
import exception.InvalidInputException;
import controller.Ui;

/**
 * Represent Command that will be executed on {@link TaskList}
 * Commands implementing this will define specific behaviours of user actions
 */
public interface ICommand {

    /**
     * Execution of task to be implemented
     *
     * @param taskList task list that contains all the task
     * @param ui       user interface that will facilitate printing
     * @throws InvalidInputException if input is invalid or in wrong format
     */
    public void execute(TaskList taskList, Ui ui) throws InvalidInputException;

    /**
     * State whether this is an exit command or not
     *
     * @return {@code true} if command should terminate the program
     */
    public boolean isExit();
}
