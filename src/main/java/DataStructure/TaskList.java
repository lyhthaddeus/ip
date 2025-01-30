package DataStructure;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Controller.Storage;
import TaskObjects.Task;

public class TaskList<T extends Task> {

  private List<T> TaskList;

  public TaskList() {
    this.TaskList = new ArrayList<>();
  }

  private static final String LINE_BREAK = "\n__________________________________________\n";


  public void load(T task) {
    this.TaskList.add(task);
 }

  public void add(T task) {
    this.TaskList.add(task);
    Storage.save(this.TaskList);

    System.out.println("Task has been successfully added");
    System.out.println(task.toString());
    this.count();
  }

  public void delete(String ids) {
    int id = Integer.parseInt(ids);
    T deleted = this.TaskList.remove(id - 1);
    Storage.save(this.TaskList);

    System.out.println("Commander, the task has been successfully deleted");
    System.out.println(deleted.toString());
    this.count();
  } 

  public void mark(String ids) {
    int id = Integer.parseInt(ids);
    this.TaskList.get(id - 1).markDone();
    Storage.save(this.TaskList);

    System.out.println("Commander, task " + ids + " has been marked completed");
    System.out.println(TaskList.get(id - 1).toString() + LINE_BREAK);
  }

  public void unmarked(String ids) {
    int id = Integer.parseInt(ids);
    this.TaskList.get(id - 1).markUndone();
    Storage.save(this.TaskList);

    System.out.println("Commander, taks " + ids + " has been mark incomplete");
    System.out.println(TaskList.get(id - 1).toString() + LINE_BREAK);
  }

  public void count() {
    int count = this.TaskList.size();
    System.out.println("Commander, you currently have " + count + " tasks" + LINE_BREAK);
  }

  public void getList() {
    System.out.println(this.toString() + LINE_BREAK);
  }

  public String toString() {
    if (TaskList.isEmpty()) {
      return "Commander, currently you have no outstanding task";
    }
    StringBuilder result = new StringBuilder();
    int count = 0;
    for (T command: TaskList) {
      count++;
      result.append(count).append(". ").append(command).append("\n");
    }

    return result.toString();
  }

}
