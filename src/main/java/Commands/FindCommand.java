package Commands;

import Controller.Ui;
import DataStructure.TaskList;
import Exception.InvalidInputException;

public class FindCommand extends AbstractCommand {
    private final String keyword;
    public FindCommand(String keyword) {
        this.keyword = keyword;
    }
    @Override
    public void execute(TaskList taskList, Ui ui) throws InvalidInputException {
        ui.showTaskMessage(taskList.find(keyword));
    }
}
