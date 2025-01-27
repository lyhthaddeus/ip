package Enums;

public enum CommandTypes {
    TODO,
    DEADLINE,
    EVENT,
    MARK,
    UNMARK,
    LIST,
    LS,
    BYE,
    Q,
    DELETE,
    DEL,
    INVALID;

    // Static method to map a command string to the corresponding enum
    public static CommandTypes fromString(String command) {
        try {
            return CommandTypes.valueOf(command.toUpperCase());
        } catch (IllegalArgumentException e) {
            return CommandTypes.INVALID;
        }
    }
}