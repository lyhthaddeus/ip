public class Command {
  
  private String description = "";
  private boolean completed;

  public Command(String description) {
    this.description = description;
    this.completed = false;
  }

  public String getDescription() {
    return this.description;
  }
  public String getStatus() {
    return (completed? "X" : " ");
  }

  public String markDone() {
    this.completed = true;
    return this.toString();
  }

  public String markUndone() {
    this.completed = false;
    return this.toString();
  }

  @Override
  public String toString() {
    return "[" + this.getStatus() + "]" + this.getDescription();
  }
}
