package TaskObjects;

import Exception.InvalidInputException;
public class Todo extends Task {
  
  public Todo(String description, boolean isCompleted) throws InvalidInputException {
    super(description, isCompleted,"T");
  }

  @Override
  public String toString() {
    return "[T]" + super.toString();
  }
}
