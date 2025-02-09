package commands;

import controller.Ui;
import datastructure.TaskList;
import exception.InvalidInputException;

/**
 * {@code FindCommand} class responsible for executing the Find
 * command
 */
public class FindCommand extends AbstractCommand {
    private final String keyword;

    /**
     * Constructs a {@code FindCommand} instance with the keyword to
     * be matched with
     *
     * @param keyword
     */
    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    /**
     * Executes the find command by calling task list for a search
     * then passing the matched cases to Ui
     * j
     *
     * @param taskList task list that contains all the task
     * @param ui       user interface that will facilitate printing
     * @throws InvalidInputException for Exception with syntax and invalid inputs
     */
    @Override
    public void execute(TaskList taskList, Ui ui) throws InvalidInputException {
        ui.showTaskMessage(taskList.find(keyword));
    }
}
