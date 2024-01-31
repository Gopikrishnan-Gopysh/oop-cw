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
        System.out.print("Enter task ID number: ");
        /*while (true)
        try ｛
        System. out print ("Id: ");
        taskId = inputs.nextInt ();
        if
        (taskid > 0) break;
        -
        System. out. printin ("Can only enter postive numbers.");
        System. out.printin();
        catch (java.til. InputMismatchException e)
        inputs.nextLine(): //Prevents an infinite loop.
        System. out.printin ("Can only enter numbers.");
        System. out.printin();
        */
        int id;
        try {
        	id = scanner.nextInt();
        	if (id > 0) {
        		
        	}
        }
        catch (java.util.InputMismatchException e) {
        	System.out.println("Invalid input. Please enter a positive whole number. ");
        	return;
        }
        

        System.out.print("Enter task name: ");
        scanner.nextLine(); 
        String name = scanner.next();

        scanner.nextLine();
        System.out.print("Enter task description (optional): ");
        String description = scanner.nextLine();

        Task newTask = new Task(id, name, description);

        if (taskManager.addTask(newTask)) {
            System.out.println("Task added successfully!");
        } else {
            System.out.println("Task not added. Task with the same ID already exists.");
        }
    }

    private static void removeTask(TaskManager taskManager, Scanner scanner) {
        System.out.println("Enter the ID number of the task to remove:");
        int taskId = scanner.nextInt();

        if (taskManager.removeTask(taskId)) {
            System.out.println("Task removed successfully!");
        } else {
            System.out.println(" No task removed. Task with the given ID number is not found.");
        }
    }
}
