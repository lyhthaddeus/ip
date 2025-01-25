public class Daiyan {

  public static void main(String[] args) {
    String asciiArt = " ____   ____   _ __  __ ____   __  _ \n" +
                      "| _) \\ / () \\ | |\\ \\/ // () \\ |  \\| |\n" +
                      "|____//__/\\__\\|_| |__|/__\\/__\\|_|\\__|"; 
    System.out.println(asciiArt);
    System.out.println("__________________________________________\nHello I'm Daiyan\nWhat can I do for you?\n__________________________________________\n");
    Logic logic = new Logic();
    logic.start();
  }
}
