import java.util.Scanner;

public class Logic {

  public void start() {
    Scanner scanner = new Scanner(System.in);
    String input;

    while(true) {
      System.out.print("How may I assist you commander?\n");
      input = scanner.nextLine();

      if (input.toLowerCase().equals("bye")) {
        System.out.println("Bye, hope to see you again commander.");
        break;
      } else {
        System.out.println("You command was " + input);
      }
    }
  }
}
