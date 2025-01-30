package TaskObjects;

import Exception.InvalidInputException;
import Interface.ICommand;

public abstract class Task implements ICommand {
  
  private String description = "";
  private boolean isCompleted;
  private final String type;

  public Task(String description, boolean isCompleted, String type) throws InvalidInputException {
    this.description = description;
    this.isCompleted = isCompleted;
    this.type = type;
    if (description == null || type == null) {
      throw new InvalidInputException("Sorry Commander, but there is missing data");
    }
  }

  private String getDescription() {
    return this.description;
  }
  private String getStatus() {
    return (isCompleted? "X" : " ");
  }

  public void markDone() {
    this.isCompleted = true;
  }

  public void markUndone() {
    this.isCompleted = false;
  }

  public String toFileFormat() {
    return this.type + " | " + this.isCompleted + " | " + this.description;
  }

  @Override
  public String toString() {
    return "[" + this.getStatus() + "] " + this.getDescription();
  }
}
