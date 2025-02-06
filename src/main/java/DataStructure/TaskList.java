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

  public String find(String keyword) {
      List<AbstractTask> filteredList = new ArrayList<>();
      filteredList = this.tasklist.stream().filter(x -> x.getDescription()
              .contains(keyword)).toList();
      if (filteredList.isEmpty()) {
          return "Sorry Commander, I couldn't find any task that fit your description";
      }
      StringBuilder result = new StringBuilder();
      int count = 0;
      for (AbstractTask task: filteredList) {
          count++;
          result.append(count).append(". ").append(task).append("\n");
      }
      return "Here are the task that matches your search\n" + result.toString();
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
    for (AbstractTask task: tasklist) {
      count++;
      result.append(count).append(". ").append(task).append("\n");
    }

    return result.toString();
  }

}
