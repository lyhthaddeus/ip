package Controller;

import DataStructure.TaskList;
import TaskObjects.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import Exception.InvalidInputException;
import Exception.StorageSyntaxException;

public class Storage {
    private static final String PATH = "./data/storage.txt";

    public static TaskList<Task> load() {
        TaskList<Task> taskList = new TaskList<>();
        File file = new File(PATH);

        if (!file.isFile()) {
            return taskList;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String readerPointer = reader.readLine();
            while (readerPointer != null) {
                Task task = parser(readerPointer);
                if (task != null) {
                    taskList.load(task);
                }
                readerPointer = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println("Sorry Commander, there appears to be an error fetching previous task: " + e.getMessage());
        }

        return taskList;
    }

    public static void save(List<? extends Task> taskList) {
        File file = new File(PATH);
        file.getParentFile().mkdirs();

        try {
            if (!file.isFile()) {
                file.createNewFile();
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
                for (Task task : taskList) {
                    writer.write(task.toFileFormat());
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Sorry Commander, there is an error with saving tasks: " + e.getMessage());
        }
    }

    private static Task parser(String input) {
        String[] split = input.split(" \\| ");

        String type = split[0].trim();
        boolean isCompleted = split[1].trim().equals("1");
        String description = split[2].trim();

        Task returnTask;
        try {
            switch (type) {
                case "T":
                    returnTask = new Todo(description, isCompleted);
                    break;
                case "D":
                    returnTask = new Deadline(description, isCompleted, split[3].trim());
                    break;
                case "E":
                    returnTask = new Event(description, isCompleted, split[3].trim(), split[4].trim());
                    break;
                default:
                    throw new StorageSyntaxException();
            }
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
            return null;
        }

        return returnTask;
    }

}
