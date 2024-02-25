package taskManagementSystem;
import java.util.ArrayList;
import java.util.List;

public class TaskManager extends ArrayList<Task> {

	public TaskManager() {
		super(); // Calls the constructor of the superclass (ArrayList)
	}

	public boolean addTask(Task newTask) {
		// An iterator is an object that can traverse through all the values step by step.
		java.util.Iterator<Task> iterator = this.iterator();
		while (iterator.hasNext()) {
			Task existingTask = iterator.next();
			if (existingTask != null && existingTask.getId() == newTask.getId()) {
				return false; // Task with the same ID already exists
			}
		}
		// If not, add the new task
		this.add(newTask);
		// Task added successfully
		return true;
	}

	public boolean removeTask(int taskId) {
		java.util.Iterator<Task> iterator = this.iterator();
		while (iterator.hasNext()) {
			Task task = iterator.next();
			if (task != null && task.getId() == taskId) {
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