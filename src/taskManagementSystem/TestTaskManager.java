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

        // Test adds tasks to the TaskManager
        assertTrue(taskManager.addTask(task1));
        // Adds the same task should return false
        assertFalse(taskManager.addTask(task1));
        assertTrue(taskManager.addTask(task2));

}
}