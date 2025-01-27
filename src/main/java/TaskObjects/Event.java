package TaskObjects;

import Exception.InvalidInputException;
public class Event extends Command {
  
  private String from;
  private String to;

  public Event (String description, String from, String to) throws InvalidInputException {
    super(description);
    this.from = from;
    this.to = to;
    if (description.isBlank() || from.isBlank() || to.isBlank()) {
      throw new InvalidInputException("Sorry Commander, but there is missing data");
    }
  }

  @Override
  public String toString() {
    return "[E]" + super.toString() + " (from: " + this.from + " to: " + this.to + ")";
  }

}
