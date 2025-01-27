package TaskObjects;

import Exception.InvalidInputException;
public class Command {
  
  private String description = "";
  private boolean completed;

  public Command(String description) throws InvalidInputException {
    this.description = description;
    this.completed = false;
    if (description == null) {
      throw new InvalidInputException("Sorry Commander, but there is missing data");
    }
  }

  public String getDescription() {
    return this.description;
  }
  public String getStatus() {
    return (completed? "X" : " ");
  }

  public void markDone() {
    this.completed = true;
  }

  public void markUndone() {
    this.completed = false;
  }

  @Override
  public String toString() {
    return "[" + this.getStatus() + "] " + this.getDescription();
  }
}
