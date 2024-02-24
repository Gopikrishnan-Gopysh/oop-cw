package taskManagementSystem;
import java.util.List;
import java.util.Scanner;

public class TextGUI {
    public static void show() {
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);

        // Load tasks from file at the beginning of the program
        TaskFileManager.readTasksFromFile(taskManager, "tasks.dat"); //.dat is a generic extension to store files without a particular format

        System.out.println("Welcome to Task Manager!");
        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("(1) Show all current tasks");
            System.out.println("(2) Add a new task");
            System.out.println("(3) Remove an existing task");
            System.out.println("(4) Exit the program");

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
                    TaskFileManager.saveTasksToFile(taskManager, "tasks.dat");
                    System.out.println("Successfully saved tasks to file and exited the program.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayAllTasks(TaskManager taskManager) {
        List < Task > tasks = taskManager.getAllTasks();
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            System.out.println("All current tasks:");
            for (Task task: tasks) {
                System.out.println(task);
            }
            System.out.println("\nReminder messages:" + taskManager.size());
            for (Task task: taskManager.getAllTasks()) {
                // If the task is a TeamWorkTask, cast it accordingly before invoking remindUser()
                if (task instanceof Remindable) {
                    if (task instanceof TeamWorkTask) {
                        ((TeamWorkTask)(Remindable) task).remindUser();
                    } else {
                        // If the task is a regular Remindable, invoke remindUser()
                        ((Remindable) task).remindUser();
                    }
                }
            }
        }
    }

    private static void addNewTask(TaskManager taskManager, Scanner scanner) {
        String idString = null;
        int err = 0;
        //if correcrt
        System.out.print("Enter task ID number: ");
        while (true) {
            try {
                idString = scanner.next();

                if (idString.matches("^[1-9][0-9]*$")) { //regular expression (^ = start, [1-9] any no from 1-9, same for [0-9], * = 0 or more times, $ = end)
                    break;
                } else {
                    if (idString.equalsIgnoreCase("H") && err == 1) {
                        return;
                    } else {
                        System.out.println("Invalid input. Please enter a positive whole number.");
                        System.out.print("Enter (H) to return to the homepage, or retry your request.");
                        err = 1;
                    }
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a positive whole number.");
                System.out.print("Enter (H) to return to the homepage, or retry your request.");
                String goBackChoice = scanner.next();

                if (goBackChoice.equalsIgnoreCase("H")) {
                    return;
                }
            }
        }

        int id = Integer.parseInt(idString);
        System.out.println("Choose the task hierarchy:");
        System.out.println("(1) Personal Task");
        System.out.println("(2) Work Task");
        System.out.println("(3) Teamwork Task");

        String hierarchyChoice = scanner.next();

        switch (hierarchyChoice) {
            case "1":
                addPersonalTask(taskManager, scanner, id);
                break;
            case "2":
                addWorkTask(taskManager, scanner, id);
                break;
            case "3":
                addTeamWorkTask(taskManager, scanner, id);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void addPersonalTask(TaskManager taskManager, Scanner scanner, int id) {
        System.out.print("Enter personal task name: ");
        scanner.nextLine();
        String name = scanner.nextLine();

        System.out.print("Enter personal task description (Press enter to skip): ");
        String description = scanner.nextLine();
        //creating a new instance
        PersonalTask newTask = new PersonalTask(id, name, description);

        if (taskManager.addTask(newTask)) {
            System.out.println("Personal Task added successfully!");
        } else {
            System.out.println("Task not added. Personal Task with the same ID already exists.");
        }
    }

    private static void addWorkTask(TaskManager taskManager, Scanner scanner, int id) {
        System.out.print("Enter work task name: ");
        scanner.nextLine();
        String name = scanner.nextLine();

        System.out.print("Enter work task description (Press enter to skip): ");
        String description = scanner.nextLine();

        WorkTask newTask = new WorkTask(id, name, description);
        //creating a new instance
        if (taskManager.addTask(newTask)) {
            System.out.println("Work Task added successfully!");
        } else {
            System.out.println("Task not added. Work task with the same ID already exists.");
        }
    }

    private static void addTeamWorkTask(TaskManager taskManager, Scanner scanner, int id) {
        System.out.print("Enter teamwork task name: ");
        scanner.nextLine();
        String name = scanner.nextLine();

        System.out.print("Enter team name for teamwork task: ");
        String teamName = scanner.nextLine();

        System.out.print("Enter teamwork task description (Press enter to skip): ");
        String description = scanner.nextLine();
        //creating a new instance
        TeamWorkTask newTask = new TeamWorkTask(id, name, description, teamName);

        if (taskManager.addTask(newTask)) {
            System.out.println("Teamwork Task added successfully!");
        } else {
            System.out.println("Task not added. Teamwork task with the same ID already exists.");
        }
    }

    private static void removeTask(TaskManager taskManager, Scanner scanner) {
        int taskId;
        while (true) {
            try {
                System.out.print("Enter the ID number of the task to remove: ");
                taskId = scanner.nextInt();
                // Check if the entered task ID is a positive whole number
                if (taskId > 0) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a positive whole number.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a positive whole number.");
                scanner.nextLine(); // Consume the invalid input to avoid an infinite loop
                System.out.print("Enter (H) to return to the homepage, or retry your request.");
                String goBackChoice = scanner.next();

                if (goBackChoice.equalsIgnoreCase("H")) {
                    return;
                }
            }
        }
        // Remove the task with the specified ID from the TaskManager
        if (taskManager.removeTask(taskId)) {
            System.out.println("Task removed successfully!");
        } else {
            System.out.println("No task removed. Task with the given ID number is not found.");
        }
    }
}