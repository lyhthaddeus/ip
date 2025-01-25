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
      input = scanner.nextLine();
      String[] parsed = input.split(" ");

      if (input.isEmpty()){
        System.out.println("Commander, please let me know how I may assist ;)\n__________________________________________\n");
      } else {
        if (parsed[0].equalsIgnoreCase("bye")) {
          System.out.println("Bye, hope to see you again commander.\n__________________________________________\n");
          break;
        } else if (parsed[0].equalsIgnoreCase("list")) {
          System.out.println(commandList.toString());
        } else if (parsed[0].equalsIgnoreCase("mark")) {
          System.out.println("Commander, task " + parsed[1] + " has been marked completed");
          System.out.println(commandList.mark(parsed[1]) + "\n__________________________________________\n");
        } else if (parsed[0].equalsIgnoreCase("unmark")) {
          System.out.println("Commander, taks " + parsed[1] + " has been mark incomplete");
          System.out.println(commandList.unmark(parsed[1]) + "\n__________________________________________\n");
        } else {
          commandList.add(new Command(input));
          System.out.println("Added " + input + "\n__________________________________________\n");
        }
      }

    }
  }
}
