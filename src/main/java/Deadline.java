public class Deadline extends Command {
  
  private String byWhen;

  public Deadline(String description, String by) {
    super(description);
    this.byWhen = by;
  }

  @Override
  public String toString() {
    return "[D]" + super.toString() + "(" + this.byWhen + ")";
  }
}
