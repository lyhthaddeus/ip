import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

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

      if (input.isEmpty()){
        System.out.println("Commander, please let me know how I may assist ;)\n__________________________________________\n");
        continue;
      }

      switch (parsed[0].toLowerCase()) {
        case ("bye"):
          System.out.println("Bye, hope to see you again commander.\n__________________________________________\n");
          return;
        case("q"):
          System.out.println("Bye, hope to see you again commander.\n__________________________________________\n");
          return;
        case ("list"):
          commandList.getList();
          break;
        case ("ls"):
          commandList.getList();
          break;
        case("mark"):
          commandList.mark(parsed[1]);
          break;
        case("unmark"):
          commandList.unmark(parsed[1]);
          break;
        case("todo"):
          commandList.add(new Todo(parsed[1]));
          break;
        case("deadline"):
          String DeadlineDescription = parsed[1].split("/by")[0];
          String DeadlineBy = parsed[1].split("/by")[1];
          commandList.add(new Deadline(DeadlineDescription, DeadlineBy));
          break;
        case("event"):
          String EventDescription = parsed[1].split("/by")[0];
          String EventFrom = parsed[1].split("/from")[1];
          String EventTo = parsed[1].split("/to")[1];
          commandList.add(new Event(EventDescription, EventFrom,EventTo));
          break;
        default:
          commandList.add(new Command(input));
          break;
      }
    }
  }
}
