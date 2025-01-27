package TaskObjects;

import Exception.InvalidInputException;

public class Deadline extends Command {
  
  private String byWhen;

  public Deadline(String description, String by) throws InvalidInputException {
    super(description);
    this.byWhen = by;

    if (description.isBlank() || byWhen.isBlank()) {
      throw new InvalidInputException("Sorry Commander, but there is missing data");
    }
  }

  @Override
  public String toString() {
    return "[D]" + super.toString() + " (by: " + this.byWhen + ")";
  }
}
