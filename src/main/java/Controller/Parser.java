package Controller;

import Commands.*;
import TaskObjects.*;

import Enums.CommandTypes;
import Exception.InvalidInputException;
import Exception.SyntaxException;

public class Parser {

  private final Storage storage;
  public Parser(Storage storage) {
    this.storage = storage;
  }

  public AbstractCommand parse(String input) throws InvalidInputException {
      String[] parsed = input.split(" ", 2);
      CommandTypes commandTypes = CommandTypes.fromString(parsed[0]);

      switch (commandTypes) {
        case BYE, Q:
          return new ExitCommand(this.storage);

        case LIST, LS:
          return new ListCommand();

        case MARK:
          if (parsed.length < 2) {
            throw new SyntaxException("mark", "mark <index of item>");
          }
          return new MarkCommand(Integer.parseInt(parsed[1]));

        case UNMARK:
          if (parsed.length < 2) {
            throw new SyntaxException("unmark", "unmark <index of item>");
          }
          return new UnmarkCommand(Integer.parseInt(parsed[1]));

        case DELETE, DEL:
          if (parsed.length < 2) {
            throw new SyntaxException("delete", "delete <index of item>");
          }
          return new DeleteCommand(Integer.parseInt(parsed[1]));

        case TODO:
          if (parsed.length < 2) {
            throw new SyntaxException("Todo", "todo <Task>");
          }
          return new AddCommand(new Todo(parsed[1], false));

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
          return new AddCommand(new Deadline(deadlineDescription, false,deadlineBy));

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
          return new AddCommand(new Event(eventDescription, false, eventFrom, eventTo));
        default:
          throw new InvalidInputException("Sorry Commander, but I do not understand your orders.");
      }
  }
}
