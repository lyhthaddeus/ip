package TaskObjects;

import Exception.InvalidInputException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Deadline extends AbstractTask {
  
  private LocalDateTime byWhen;

  private static final DateTimeFormatter INPUT_FORMAT = DateTimeFormatter.ofPattern("d/M/yyyy HHmm");
  private static final DateTimeFormatter OUTPUT_FORMAT = DateTimeFormatter.ofPattern("MMM dd yyyy, h:mma");

  public Deadline(String description, boolean isCompleted, String byWhen) throws InvalidInputException {
    super(description, isCompleted, "D");
    try {
      this.byWhen = LocalDateTime.parse(byWhen, INPUT_FORMAT);
    } catch (DateTimeParseException e) {
      throw new InvalidInputException("Invalid date format Commander. Pleaser use d/M/yyyy HHmm (e.g., 2/12/1989 1800).");
    }

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
    return "[D]" + super.toString() + " (by: " + this.byWhen.format(OUTPUT_FORMAT) + ")";
  }
}
