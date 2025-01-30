package TaskObjects;

import Exception.InvalidInputException;

public class Deadline extends Task {
  
  private String byWhen;

  public Deadline(String description, boolean isCompleted, String by) throws InvalidInputException {
    super(description, isCompleted, "D");
    this.byWhen = by;

    if (description.isBlank() || byWhen.isBlank()) {
      throw new InvalidInputException("Sorry Commander, but there is missing data");
    }
  }

  @Override
  public String toFileFormat() {
    return super.toFileFormat() + " | " + this.byWhen;
  }

  @Override
  public String toString() {
    return "[D]" + super.toString() + " (by: " + this.byWhen + ")";
  }
}
