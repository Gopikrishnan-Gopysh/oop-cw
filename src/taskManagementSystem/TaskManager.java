package taskManagementSystem;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> tasks;

    public TaskManager() {
        this.tasks = new ArrayList<>();
    }

    public boolean addTask(Task newTask) {
        // Checks if task with the same ID already exists
        for (Task existingTask : tasks) {
            if (existingTask.getId() == newTask.getId()) {
            	// Task with the same ID already exists
                return false; 
            }
        }

        // If not, add the new task
        tasks.add(newTask);
        // Task added successfully
        return true;
    }

    public boolean removeTask(int taskId) {
        // Use iterator to safely remove elements while iterating
        java.util.Iterator<Task> iterator = tasks.iterator();
        while (iterator.hasNext()) {
            Task task = iterator.next();
            if (task.getId() == taskId) {
                iterator.remove();
                return true; // Task removed successfully
            }
        }
        return false; // Task with the given ID not found
    
        }
    public int getSize() {
        return tasks.size();
    }

    public List<Task> getAllTasks() {
        return tasks;
    }
}


