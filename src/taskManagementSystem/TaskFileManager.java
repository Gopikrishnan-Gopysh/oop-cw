package taskManagementSystem;

import java.io.*;

public class TaskFileManager {

    public static void saveTasksToFile(TaskManager taskManager, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            // Iterate through all tasks in the TaskManager
            for (Task eachTask: taskManager.getAllTasks()) {
                writer.write(taskToString(eachTask));
                writer.newLine();
            }
        } catch (IOException e) {
            // Handle IOException during file writing
            e.printStackTrace(); //for debugging purposes
            System.err.println("Error saving tasks to file: " + e.getMessage());
        }
    }

    private static String taskToString(Task task) {
        if (task instanceof TeamWorkTask) {
            return ((TeamWorkTask) task).taskToString();
        } else {
            return task.taskToString();
        }

    }

    public static void readTasksFromFile(TaskManager taskManager, String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("Welcome to Task Manager!");
            return;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            int lineNumber = 0;
            while ((line = reader.readLine()) != null) {
                lineNumber++;
                // Convert the string representation of the task to a Task object and add it to the TaskManager
                try {
                    Task eachTask = stringToTask(line);
                    if (eachTask != null) {
                        taskManager.addTask(eachTask);
                    }
                } catch (Exception e) {
                	//for debugging purposes
                    System.err.println("Error parsing line " + lineNumber + ": " + line); 
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); //for debugging purposes
            System.err.println("Error reading tasks from file: " + e.getMessage());
        }
    }

    private static Task stringToTask(String taskString) {
        return Task.stringToTask(taskString);
    }
}