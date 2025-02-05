package Controller;

import DataStructure.TaskList;
import TaskObjects.*;
import java.io.*;
import java.util.List;
import Exception.InvalidInputException;
import Exception.StorageSyntaxException;

public class Storage {
    private final String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    public TaskList load() throws InvalidInputException {
        TaskList taskList = new TaskList();
        File file = new File(this.filePath);

        if (!file.isFile()) {
            return taskList;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String readerPointer = reader.readLine();
            while (readerPointer != null) {
                AbstractTask abstractTask = parser(readerPointer);
                if (abstractTask != null) {
                    taskList.load(abstractTask);
                }
                readerPointer = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println("Sorry Commander, there appears to be an error fetching previous task: " + e.getMessage());
        }

        return taskList;
    }

    public void save(List<? extends AbstractTask> taskList) {
        File file = new File(this.filePath);
        file.getParentFile().mkdirs();

        try {
            if (!file.isFile()) {
                file.createNewFile();
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
                for (AbstractTask abstractTask : taskList) {
                    writer.write(abstractTask.toFileFormat());
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Sorry Commander, there is an error with saving tasks: " + e.getMessage());
        }
    }

    private AbstractTask parser(String input) throws InvalidInputException {
        String[] split = input.split(" \\| ");

        String type = split[0].trim();
        boolean isCompleted = split[1].trim().equals("1");
        String description = split[2].trim();

        AbstractTask returnAbstractTask;

        switch (type) {
            case "T":
                returnAbstractTask = new Todo(description, isCompleted);
                break;
            case "D":
                returnAbstractTask = new Deadline(description, isCompleted, split[3].trim());
                break;
            case "E":
                returnAbstractTask = new Event(description, isCompleted, split[3].trim(), split[4].trim());
                break;
            default:
                throw new StorageSyntaxException();
        }

        return returnAbstractTask;
    }

}
