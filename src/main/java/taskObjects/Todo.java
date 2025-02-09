package taskObjects;

import exception.InvalidInputException;

/**
 * {@code Todo} class to handle task with no start or due time
 */
public class Todo extends AbstractTask {

    /**
     * Constructs a {@code Todo} instance
     *
     * @param description Simple description of the task
     * @param isCompleted Completion status of the task
     * @throws InvalidInputException if input is invalid or in wrong format
     */
    public Todo(String description, boolean isCompleted) throws InvalidInputException {
        super(description, isCompleted, "T");
    }

    /**
     * Gets the String representation of Todo
     *
     * @return String representation of Todo
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
