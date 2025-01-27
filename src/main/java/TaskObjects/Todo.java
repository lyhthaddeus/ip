package TaskObjects;

import Exception.InvalidInputException;
public class Todo extends Command {
  
  public Todo(String description) throws InvalidInputException {
    super(description);
  }

  @Override
  public String toString() {
    return "[T]" + super.toString();
  }
}
