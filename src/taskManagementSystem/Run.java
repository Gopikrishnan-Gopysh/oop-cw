package taskManagementSystem;
import java.util.List;
import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Task Manager!");

        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("(1)Show all current tasks");
            System.out.println("(2)Add a new task");
            System.out.println("(3)Remove an existing task");
            System.out.println("(4)Exit");

            String choice = scanner.next();

            switch (choice) {
                case "1":
                    displayAllTasks(taskManager);
                    break;
                case "2":
                    addNewTask(taskManager, scanner);
                    break;
                case "3":
                    removeTask(taskManager, scanner);
                    break;
                case "4":
                    System.out.println("Successfully exited the program.");
                    System.exit(0);
                    break;
                    
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayAllTasks(TaskManager taskManager) {
    	// Retrieves all task(s) from the TaskManager
        List<Task> tasks = taskManager.getAllTasks();
        //if there are no tasks, run this
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            //if there are task(s), run this
        } else {
            System.out.println("All current tasks:");
            for (Task task : tasks) {
                System.out.println(task);
            }
        }
    }

    private static void addNewTask(TaskManager taskManager, Scanner scanner) {
        System.out.println("Enter task ID number:");
        int id = scanner.nextInt();

        System.out.println("Enter task name:");
        scanner.nextLine(); 
        String name = scanner.nextLine();

        System.out.println("Enter task description (optional):");
        String description = scanner.nextLine();

        Task newTask = new Task(id, name, description);

        if (taskManager.addTask(newTask)) {
            System.out.println("Task added successfully!");
        } else {
            System.out.println("Task with the same ID already exists. Task not added.");
        }
    }

    private static void removeTask(TaskManager taskManager, Scanner scanner) {
        System.out.println("Enter the ID number of the task to remove:");
        int taskId = scanner.nextInt();

        if (taskManager.removeTask(taskId)) {
            System.out.println("Task removed successfully!");
        } else {
            System.out.println("Task with the given ID number is not found. No task removed.");
        }
    }
}
