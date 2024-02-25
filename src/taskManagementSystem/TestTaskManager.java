package taskManagementSystem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.util.List;

class TestTaskManager {

    @Test
    void testAddTask() {
        // Creates a TaskManager instance
        TaskManager taskManager = new TaskManager();
        // Creates two tasks with different IDs
        Task task1 = new PersonalTask(1, "Task 1", "Personal Description");
        Task task2 = new WorkTask(2, "Task 2", "Work Description");

        // Test for adding task to the TaskManager
        assertTrue(taskManager.addTask(task1));
        assertFalse(taskManager.addTask(task1)); // Adding the same task should return false
        assertTrue(taskManager.addTask(task2));

        // Add PersonalTask, WorkTask, TeamWorkTask
        assertTrue(taskManager.addTask(new PersonalTask(3, "Personal Task", "Personal Description")));
        assertTrue(taskManager.addTask(new WorkTask(4, "Work Task", "Work Description")));
        assertTrue(taskManager.addTask(new TeamWorkTask(5, "TeamWork Task", "TeamWork Description", "Team A")));
        
        // Additional test for saving and reading tasks from file
        testSaveAndReadTasks();
    }

    @Test
    void testRemoveTask() {
        // Creates a TaskManager instance
        TaskManager taskManager = new TaskManager();
        // Create two tasks with different IDs
        Task task1 = new PersonalTask(1, "Task 1", "Personal Description");
        Task task2 = new WorkTask(2, "Task 2", "Work Description");

        // Adds tasks to the TaskManager
        taskManager.addTask(task1);
        taskManager.addTask(task2);

        // Test for removing tasks from the TaskManager
        assertTrue(taskManager.removeTask(1));
        assertFalse(taskManager.removeTask(1)); // Removing the same task again should return false
        assertTrue(taskManager.removeTask(2));
        assertFalse(taskManager.removeTask(3)); // Removing non-existent task should return false
        
        // Remove PersonalTask, WorkTask, TeamWorkTask
        taskManager.addTask(new PersonalTask(4, "Personal Task", "Personal Description"));
        taskManager.addTask(new WorkTask(5, "Work Task", "Work Description"));
        taskManager.addTask(new TeamWorkTask(6, "TeamWork Task", "TeamWork Description", "Team A"));

        assertTrue(taskManager.removeTask(4));
        assertTrue(taskManager.removeTask(5));
        // Removing non-existent task should return false
        assertFalse(taskManager.removeTask(7));
        
        // Additional test for saving and reading tasks from file
        testSaveAndReadTasks();
    }

    @Test
    void testGetSize() {
        // Creates a TaskManager instance
        TaskManager taskManager = new TaskManager();
        // Creates two tasks with different IDs
        Task task1 = new PersonalTask(1, "Task 1", "Personal Description");
        Task task2 = new WorkTask(2, "Task 2", "Work Description");

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

        // Add and remove PersonalTask, WorkTask, TeamWorkTask
        taskManager.addTask(new PersonalTask(3, "Personal Task", "Personal Description"));
        taskManager.addTask(new WorkTask(4, "Work Task", "Work Description"));
        taskManager.addTask(new TeamWorkTask(5, "TeamWork Task", "TeamWork Description", "Team A"));

        assertEquals(4, taskManager.getSize());

        taskManager.removeTask(4);
        assertEquals(3, taskManager.getSize());
        
        // Additional test for saving and reading tasks from file
        testSaveAndReadTasks();
    }

    @Test
    void testGetAllTasks() {
        // Creates a TaskManager instance
        TaskManager taskManager = new TaskManager();
        // Creates two tasks with different IDs
        Task task1 = new PersonalTask(1, "Task 1", "Personal Description");
        Task task2 = new WorkTask(2, "Task 2", "Work Description");

        // Adding tasks to the TaskManager
        taskManager.addTask(task1);
        taskManager.addTask(task2);

        // Test for getting all tasks from the TaskManager
        assertEquals(2, taskManager.getAllTasks().size());
        assertTrue(taskManager.getAllTasks().contains(task1));
        assertTrue(taskManager.getAllTasks().contains(task2));

        // Add PersonalTask, WorkTask, TeamWorkTask
        taskManager.addTask(new PersonalTask(3, "Personal Task", "Personal Description"));
        taskManager.addTask(new WorkTask(4, "Work Task", "Work Description"));
        taskManager.addTask(new TeamWorkTask(5, "TeamWork Task", "TeamWork Description", "Team A"));

        // Test for getting all tasks including PersonalTask, WorkTask, TeamWorkTask
        assertEquals(5, taskManager.getAllTasks().size());
        
        // Additional test for saving and reading tasks from file
        testSaveAndReadTasks();
    }

    @Test
    void testSaveAndReadTasks() {
        // Creates a TaskManager instance
        TaskManager taskManager = new TaskManager();

        // Adds some tasks to the TaskManager
        taskManager.addTask(new PersonalTask(1, "Task 1", "Personal Description"));
        taskManager.addTask(new WorkTask(2, "Task 2", "Work Description"));
        taskManager.addTask(new TeamWorkTask(3, "Task 3", "Team A", "TeamWork Description"));

        // Define the test file name for saving and reading tasks
        String testFileName = "test_tasks_io.dat";

        try {
            // Save tasks to file
            TaskFileManager.saveTasksToFile(taskManager, testFileName);

            // Create a new TaskManager to load tasks into
            TaskManager loadedTaskManager = new TaskManager();

            // Read tasks from file
            TaskFileManager.readTasksFromFile(loadedTaskManager, testFileName);

            // Verify that the loaded TaskManager contains the same tasks
            List<Task> expectedTasks = taskManager.getAllTasks();
            List<Task> actualTasks = loadedTaskManager.getAllTasks();

            assertEquals(expectedTasks.size(), actualTasks.size());

            for (int i = 0; i < expectedTasks.size(); i++) {
                assertEquals(expectedTasks.get(i).taskToString(), actualTasks.get(i).taskToString());
            }
        } finally {
            // Cleanup: Delete the test file after the test
            File testFile = new File(testFileName);
            if (testFile.exists()) {
                testFile.delete();
            }
        }
    }
}
