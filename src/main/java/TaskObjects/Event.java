package TaskObjects;

import Exception.InvalidInputException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Event extends Task {
  
  private LocalDateTime fromWhen;
  private LocalDateTime toWhen;
  private static final DateTimeFormatter INPUT_FORMAT = DateTimeFormatter.ofPattern("d/M/yyyy HHmm");
  private static final DateTimeFormatter OUTPUT_FORMAT = DateTimeFormatter.ofPattern("MMM dd yyyy, h:mma");

  public Event(String description, boolean isCompleted, String from, String to) throws InvalidInputException {
    super(description, isCompleted, "E");
    try {
      this.fromWhen = LocalDateTime.parse(from, INPUT_FORMAT);
      this.toWhen = LocalDateTime.parse(to, INPUT_FORMAT);
    } catch (DateTimeParseException e) {
      throw new InvalidInputException("Invalid date format Commander. Pleaser use d/M/yyyy HHmm (e.g., 2/12/1989 1800).");
    }

    if (description.isBlank() || from.isBlank() || to.isBlank()) {
      throw new InvalidInputException("Sorry Commander, but there is missing data");
    }
  }

  @Override
  public String toFileFormat() {
    return super.toFileFormat() + " | " + this.fromWhen.format(OUTPUT_FORMAT) + " | " + this.toWhen.format(OUTPUT_FORMAT);
  }

  @Override
  public String toString() {
    return "[E]" + super.toString() + " (from: " + this.fromWhen.format(OUTPUT_FORMAT) + " to: " + this.toWhen.format(OUTPUT_FORMAT) + ")";
  }

}
