package taskManagementSystem;
import java.util.List;
import java.util.Scanner;

public class TextGUI {
    public static void show() {
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
        int id;

        System.out.print("Enter task ID number: ");
        while (true) {
            try {
                id = scanner.nextInt();
                //HOW TO MAKE ALPHANUMERIC INVALID?

                if (id > 0) {
                    break; // Break out of the loop if a positive whole number is entered
                } else {
                    System.out.println("Invalid input. Please enter a positive whole number. ");
                    System.out.print("Enter (H) to return to the homepage, or retry your request.");
                    String goBackChoice = scanner.next();

                    if (goBackChoice.equalsIgnoreCase("H")) {
                        return; // Returning from the method will go back to the main page
                    }
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a positive whole number. ");
                System.out.print("Enter (H) to return to the homepage, or retry your request.");
                String goBackChoice = scanner.next();

                if (goBackChoice.equalsIgnoreCase("H")) {
                    return; // Returning from the method will go back to the main page
                }
            }
        }

        System.out.print("Enter task name: ");
        scanner.nextLine(); // Consume the newline character
        String name = scanner.nextLine();

        System.out.print("Enter task description (Press enter to skip): ");
        String description = scanner.nextLine();

        Task newTask = new Task(id, name, description);

        if (taskManager.addTask(newTask)) {
            System.out.println("Task added successfully!");
        } else {
            System.out.println("Task not added. Task with the same ID already exists.");
        }
    }

    private static void removeTask(TaskManager taskManager, Scanner scanner) {
        int taskId;
        while (true) {
            try {
                System.out.print("Enter the ID number of the task to remove: ");
                taskId = scanner.nextInt();

                if (taskId > 0) {
                    break; // Break out of the loop if a positive whole number is entered
                } else {
                    System.out.println("Invalid input. Please enter a positive whole number.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a positive whole number.");
                scanner.nextLine(); // Consume the invalid input to avoid an infinite loop
                System.out.print("Enter (H) to return to the homepage, or retry your request.");
                String goBackChoice = scanner.next();

                if (goBackChoice.equalsIgnoreCase("H")) {
                    return; // Returning from the method will go back to the main page
                }
            }
        }
        if (taskManager.removeTask(taskId)) {
            System.out.println("Task removed successfully!");
        } else {
            System.out.println(" No task removed. Task with the given ID number is not found.");
        }
    }
}

