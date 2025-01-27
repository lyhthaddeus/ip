package DataStructure;

import java.util.ArrayList;
import java.util.List;
import TaskObjects.Command;

public class CommandList<T extends Command> {
  
  private List<T> commandList;

  public CommandList() {
    this.commandList = new ArrayList<>();
  }

  public void add(T command) {
    this.commandList.add(command);
    System.out.println("Task has been successfully added");
    System.out.println(command.toString());
    this.count();
  }

  public void delete(String ids) {
    int id = Integer.parseInt(ids);
    T deleted = this.commandList.remove(id - 1);
    System.out.println("Commander, the task has been successfully deleted");
    System.out.println(deleted.toString());
    this.count();
  } 

  public void mark(String ids) {
    int id = Integer.parseInt(ids);
    this.commandList.get(id - 1).markDone();
    System.out.println("Commander, task " + ids + " has been marked completed");
    System.out.println(commandList.get(id - 1).toString() + "\n__________________________________________\n");
  }

  public void unmark(String ids) {
    int id = Integer.parseInt(ids);
    System.out.println("Commander, taks " + ids + " has been mark incomplete");
    this.commandList.get(id - 1).markUndone();
    System.out.println(commandList.get(id - 1).toString() + "\n__________________________________________\n");
  }

  public void count() {
    int count = this.commandList.size();
    System.out.println("Commander, you currently have " + count + " tasks" + "\n__________________________________________\n");
  }

  public void getList() {
    System.out.println(this.toString());
    System.out.println("__________________________________________\n");
  }

  public String toString() {
    if (commandList.isEmpty()) {
      return "Commander, currently you have no outstanding task";
    }
    StringBuilder result = new StringBuilder();
    int count = 0;
    for (T command: commandList) {
      count++;
      result.append(count).append(". ").append(command).append("\n");
    }

    return result.toString();
  }

}
