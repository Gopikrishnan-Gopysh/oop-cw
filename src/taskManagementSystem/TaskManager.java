package taskManagementSystem;
import java.util.ArrayList;
import java.util.List;

public class TaskManager extends ArrayList<Task> {

    public TaskManager() {
        super(); // Calls the constructor of the superclass (ArrayList)
    }

    public boolean addTask(Task newTask) {
        // Checks if task with the same ID already exists
        for (Task existingTask : this) {
    	if (existingTask != null && existingTask.getId() == newTask.getId()) {
            	// Task with the same ID already exists
                return false; 
            }
        }

        // If not, add the new task
        this.add(newTask);
        // Task added successfully
        return true;
    }

    public boolean removeTask(int taskId) {
    	//An iterator is an object that can traverse through all the values step by step.
        java.util.Iterator<Task> iterator = this.iterator();
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
        return this.size();
    }

    public List<Task> getAllTasks() {
        return this;
    }
}