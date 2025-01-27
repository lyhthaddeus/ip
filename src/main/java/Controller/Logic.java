package Controller;

import java.util.Scanner;
import DataStructure.CommandList;
import TaskObjects.*;

import Exception.InvalidInputException;
import Exception.SyntaxException;

public class Logic {

  private CommandList<Command> commandList;

  public Logic() {
    this.commandList = new CommandList<>();
  }

  public void start() {
    Scanner scanner = new Scanner(System.in);
    String input;
    System.out.print("How may I assist you commander?\n__________________________________________\n");

    while(true) {
      input = scanner.nextLine().trim();
      String[] parsed = input.split(" ", 2);

      try {
        switch (parsed[0].toLowerCase()) {
          case ("bye"), ("q"):
            System.out.println("Bye, hope to see you again Commander.\n__________________________________________\n");
            return;
          case ("list"), ("ls"):
            commandList.getList();
            break;
          case("mark"):
            commandList.mark(parsed[1]);
            break;
          case("unmark"):
            commandList.unmark(parsed[1]);
            break;
          case("todo"):
            if (parsed.length < 2) {
              throw new SyntaxException("Event", "event <Task> /from <Time> /to <Time>");
            }
            commandList.add(new Todo(parsed[1]));
            break;
          case("deadline"):
            if (parsed.length < 2) {
              throw new SyntaxException("Deadline", "deadline <Task> /by <Time>");
            }
            String[] deadlinePartition = parsed[1].split("/by");
            if (deadlinePartition.length < 2) {
              throw new SyntaxException("Deadline", "deadline <Task> /by <Time>");
            }
            String deadlineDescription = deadlinePartition[0].trim();
            String deadlineBy = deadlinePartition[1].trim();
            commandList.add(new Deadline(deadlineDescription, deadlineBy));
            break;
          case("event"):
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
            commandList.add(new Event(eventDescription, eventFrom, eventTo));
            break;
          default:
            throw new InvalidInputException("Sorry Commander, but I do not understand your orders.");
        }
      } catch (InvalidInputException e) {
        System.out.println(e.getMessage() + "\n__________________________________________\n");
      }
    }
  }
}
