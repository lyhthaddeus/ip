package Controller;

import java.io.IOException;
import java.util.Scanner;
import DataStructure.TaskList;
import TaskObjects.*;

import Enums.CommandTypes;
import Exception.InvalidInputException;
import Exception.SyntaxException;

public class Parser {

  private TaskList<Task> taskList;
  private static final String LINE_BREAK = "\n__________________________________________\n";

  public Parser() {
  }

  public void start() {
    Scanner scanner = new Scanner(System.in);
    String input;
    System.out.print("How may I assist you commander?" + LINE_BREAK);
    this.taskList = Storage.load();

    while(true) {
      input = scanner.nextLine().trim();
      String[] parsed = input.split(" ", 2);
      CommandTypes commandTypes = CommandTypes.fromString(parsed[0]);

      try {
        switch (commandTypes) {
          case BYE, Q:
            System.out.println("Bye, hope to see you again Commander." + LINE_BREAK);
            return;
          case LIST, LS:
            taskList.getList();
            break;
          case MARK:
            if (parsed.length < 2) {
              throw new SyntaxException("mark", "mark <index of item>");
            }
            taskList.mark(parsed[1]);
            break;
          case UNMARK:
            if (parsed.length < 2) {
              throw new SyntaxException("unmark", "unmark <index of item>");
            }
            taskList.unmarked(parsed[1]);
            break;
          case DELETE, DEL:
            if (parsed.length < 2) {
              throw new SyntaxException("delete", "delete <index of item>");
            }
            taskList.delete(parsed[1]);
            break;
          case TODO:
            if (parsed.length < 2) {
              throw new SyntaxException("Todo", "todo <Task>");
            }
            taskList.add(new Todo(parsed[1], false));
            break;
          case DEADLINE:
            if (parsed.length < 2) {
              throw new SyntaxException("Deadline", "deadline <Task> /by <Time>");
            }
            String[] deadlinePartition = parsed[1].split("/by");
            if (deadlinePartition.length < 2) {
              throw new SyntaxException("Deadline", "deadline <Task> /by <Time>");
            }
            String deadlineDescription = deadlinePartition[0].trim();
            String deadlineBy = deadlinePartition[1].trim();
            taskList.add(new Deadline(deadlineDescription, false,deadlineBy));
            break;
          case EVENT:
            if (parsed.length < 2) {
              throw new SyntaxException("Event", "event <Task> /from <Time> /to <Time>");
            }
            String[] eventPartition1 = parsed[1].split("/from");
            if (eventPartition1.length < 2) {
              throw new SyntaxException("Event", "event <Task> /from <Time> /to <Time>");
            }
            String eventDescription = eventPartition1[0].trim();
            String[] eventPartition2 = eventPartition1[1].split("/to");
            if (eventPartition2.length < 2) {
              throw new SyntaxException("Event", "event <Task> /from <Time> /to <Time>");
            }
            String eventFrom = eventPartition2[0].trim();
            String eventTo = eventPartition2[1].trim();
            taskList.add(new Event(eventDescription, false, eventFrom, eventTo));
            break;
          default:
            throw new InvalidInputException("Sorry Commander, but I do not understand your orders.");
        }
      } catch (InvalidInputException e) {
        System.out.println(e.getMessage() + LINE_BREAK);
      }
    }
  }
}
