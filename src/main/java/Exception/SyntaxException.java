package Exception;

public class SyntaxException extends InvalidInputException {
  public SyntaxException(String type, String style) {
    super("Apologies Commander, invalid " + type + " format. Please use (" + style + ").");
  }
}
