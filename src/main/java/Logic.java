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

    while(true) {
      System.out.print("How may I assist you commander?\n__________________________________________\n");
      input = scanner.nextLine();

      if (input.equalsIgnoreCase("bye")) {
        System.out.println("Bye, hope to see you again commander.\n__________________________________________\n");
        break;
      } else if (input.equalsIgnoreCase("list")) {
        System.out.println(commandList.toString());
      } else {
        commandList.add(new Command(input));
        System.out.println("Added " + input + "\n__________________________________________\n");
      }
    }
  }
}
