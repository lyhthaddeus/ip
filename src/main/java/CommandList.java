import java.util.ArrayList;
import java.util.List;

public class CommandList<T extends Command> {
  
  private List<T> commandList;

  public CommandList() {
    this.commandList = new ArrayList<>();
  }

  public void add(T command) {
    this.commandList.add(command);
  }

  public String mark(String ids) {
    int id = Integer.parseInt(ids);
    return this.commandList.get(id - 1).markDone();

  }

  public String unmark(String ids) {
    int id = Integer.parseInt(ids);
    return this.commandList.get(id - 1).markUndone();
	}

  public String toString() {
    StringBuilder result = new StringBuilder();
    int count = 0;
    for (T command: commandList) {
      count++;
      result.append(count).append(". ").append(command).append("\n");
    }

    return result.toString();
  }

}
