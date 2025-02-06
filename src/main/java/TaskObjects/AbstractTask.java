package TaskObjects;

import Exception.InvalidInputException;
import Interface.ITask;

public abstract class AbstractTask implements ITask {
  
  private String description = "";
  private boolean isCompleted;
  private final String type;

  public AbstractTask(String description, boolean isCompleted, String type) throws InvalidInputException {
    this.description = description;
    this.isCompleted = false;
    this.type = type;
    if (description == null || type == null) {
      throw new InvalidInputException("Sorry Commander, but there is missing data");
    }
  }

  public String getDescription() {
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
