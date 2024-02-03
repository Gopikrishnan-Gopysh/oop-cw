package taskManagementSystem;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class TestTaskManager {

    @Test
    void testAddTask() {
        // Creates a TaskManager instance
        TaskManager taskManager = new TaskManager();
        // Creates two tasks with different IDs
        Task task1 = new Task(1, "Task 1", "Description 1");
        Task task2 = new Task(2, "Task 2", "Description 2");

        // Test for adding task to the TaskManager
        assertTrue(taskManager.addTask(task1));
        // Adding the same task should return false
        assertFalse(taskManager.addTask(task1));
        assertTrue(taskManager.addTask(task2));
    }

    @Test
    void testRemoveTask() {
    	//HOW TO FIX ERROR?
        // Creates a TaskManager instance
        TaskManager taskManager = new TaskManager();
        // Create two tasks with different IDs
        Task task1 = new Task(1, "Task 1", "Description 1");
        Task task2 = new Task(2, "Task 2", "Description 2");

        // Adds tasks to the TaskManager
        taskManager.addTask(task1);
        taskManager.addTask(task2);

        // Test for removing tasks from the TaskManager
        assertTrue(taskManager.removeTask(1));
        // Removing the same task again should return false
        assertFalse(taskManager.removeTask(1));
        assertTrue(taskManager.removeTask(2));
        // Removing non-existent task should return false
        assertFalse(taskManager.removeTask(3));
        // Removing non-existent task should return false
        assertFalse(taskManager.removeTask(6));
    }

    @Test
    void testGetSize() {
        // Creates a TaskManager instance
        TaskManager taskManager = new TaskManager();
        // Creates two tasks with different IDs
        Task task1 = new Task(1, "Task 1", "Description 1");
        Task task2 = new Task(2, "Task 2", "Description 2");

        // Test for getting the size of the TaskManager
        assertEquals(0, taskManager.getSize());

        // Adds tasks to the TaskManager
        taskManager.addTask(task1);
        assertEquals(1, taskManager.getSize());

        taskManager.addTask(task2);
        assertEquals(2, taskManager.getSize());

        // Removes a task and check the size
        taskManager.removeTask(1);
        assertEquals(1, taskManager.getSize());

        assertEquals(4, taskManager.getSize());

        taskManager.removeTask(4);
        assertEquals(3, taskManager.getSize());
    }

    @Test
    void testGetAllTasks() {
        // Creates a TaskManager instance
        TaskManager taskManager = new TaskManager();
        // Creates two tasks with different IDs
        Task task1 = new Task(1, "Task 1", "Description 1");
        Task task2 = new Task(2, "Task 2", "Description 2");

        // Adding tasks to the TaskManager
        taskManager.addTask(task1);
        taskManager.addTask(task2);

        // Test for getting all tasks from the TaskManager
        assertEquals(2, taskManager.getAllTasks().size());
        assertTrue(taskManager.getAllTasks().contains(task1));
        assertTrue(taskManager.getAllTasks().contains(task2));

       
    }
}
