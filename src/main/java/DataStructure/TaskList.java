package DataStructure;

import java.util.ArrayList;
import java.util.List;

import Controller.Storage;
import TaskObjects.AbstractTask;

public class TaskList {

  private List<AbstractTask> tasklist;

  public TaskList() {
      this.tasklist = new ArrayList<>();
  }

  public List<AbstractTask> getlist() {
      return this.tasklist;
  }


  public void load(AbstractTask task) {
    this.tasklist.add(task);
 }

  public String add(AbstractTask task) {
    this.tasklist.add(task);
    return ("Task has been successfully added\n" + task.toString() + "\n" + this.count());
  }

  public String delete(int id) {
    AbstractTask deletedTask = this.tasklist.remove(id - 1);
    return ("Commander, the task has been successfully deleted\n" + deletedTask.toString()
            + "\n" + this.count());
  } 

  public String mark(int id) {
    this.tasklist.get(id - 1).markDone();
    return ("Commander, task " + id + " has been marked completed\n"
            + tasklist.get(id - 1).toString());
  }

  public String unmarked(int id) {
    this.tasklist.get(id - 1).markUndone();
    return ("Commander, taks " + id + " has been mark incomplete\n"
            + tasklist.get(id - 1).toString());
  }

  public String count() {
    int count = this.tasklist.size();
    return "Commander, you currently have " + count + " tasks";
  }

  public String getTaskList() {
   return this.toString();
  }

  public String toString() {
    if (tasklist.isEmpty()) {
      return "Commander, currently you have no outstanding task";
    }
    StringBuilder result = new StringBuilder();
    int count = 0;
    for (AbstractTask command: tasklist) {
      count++;
      result.append(count).append(". ").append(command).append("\n");
    }

    return result.toString();
  }

}
