package taskManagementSystem;

import java.util.List;
import java.util.Scanner;

public class TextGUI {

	public static void show() {
		TaskManager taskManager = new TaskManager();
		Scanner scanner = new Scanner(System.in);

		// Load tasks from file if existent to avoid duplication of tasks
		TaskFileManager.readTasksFromFile(taskManager, "tasks.dat");

		while (true) {
			System.out.println("\nChoose an operation:");
			System.out.println("(1) Show all current tasks");
			System.out.println("(2) Add a new task");
			System.out.println("(3) Remove an existing task");
			System.out.println("(4) Save and exit the program");

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
		List<Task> taskList = taskManager.getAllTasks();
		if (taskList.isEmpty()) {
			System.out.println("No tasks available.");
		} else {
			System.out.println("All current tasks:");
			for (Task eachTask : taskList) {
				System.out.println(eachTask);
			}
			System.out.println("\nReminder messages: " + taskManager.size());
			System.out.println();
			for (Task eachTask : taskManager.getAllTasks()) {
				if (eachTask instanceof Remindable) {
					if (eachTask instanceof TeamWorkTask) {
						((TeamWorkTask) (Remindable) eachTask).remindUser();
					} else {
						((Remindable) eachTask).remindUser();
					}
				}
			}
		}
	}

	private static void addNewTask(TaskManager taskManager, Scanner scanner) {
		System.out.print("Enter task ID number: ");
		int id = getPositiveIntegerInput(scanner);

		if (id == -1) {
			return;
		}

		System.out.println("Choose the task hierarchy:");
		System.out.println("(1) Personal Task");
		System.out.println("(2) Work Task");
		System.out.println("(3) Teamwork Task");

		int hierarchyChoice = getPositiveIntegerInput(scanner);

		switch (hierarchyChoice) {
		case 1:
			addPersonalTask(taskManager, scanner, id);
			break;
		case 2:
			addWorkTask(taskManager, scanner, id);
			break;
		case 3:
			addTeamWorkTask(taskManager, scanner, id);
			break;
		default:
			System.out.println("Invalid choice. Please try again.");
		}
	}

	private static void addPersonalTask(TaskManager taskManager, Scanner scanner, int id) {
		System.out.print("Enter personal task name: ");
		scanner.nextLine(); // Consume newline
		String name = scanner.nextLine();

		System.out.print("Enter personal task description (Press enter to skip): ");
		String description = scanner.nextLine();
		PersonalTask newTask = new PersonalTask(id, name, description);

		if (taskManager.addTask(newTask)) {
			System.out.println("Personal Task added successfully!");
		} else {
			System.out.println("Task not added. Personal Task with the same ID already exists.");
		}
	}

	private static void addWorkTask(TaskManager taskManager, Scanner scanner, int id) {
		System.out.print("Enter work task name: ");
		scanner.nextLine(); // Consume newline
		String name = scanner.nextLine();

		System.out.print("Enter work task description (Press enter to skip): ");
		String description = scanner.nextLine();

		WorkTask newTask = new WorkTask(id, name, description);
		if (taskManager.addTask(newTask)) {
			System.out.println("Work Task added successfully!");
		} else {
			System.out.println("Task not added. Work task with the same ID already exists.");
		}
	}

	private static void addTeamWorkTask(TaskManager taskManager, Scanner scanner, int id) {
		System.out.print("Enter teamwork task name: ");
		scanner.nextLine(); // Consume newline
		String name = scanner.nextLine();

		System.out.print("Enter team name for teamwork task: ");
		String teamName = scanner.nextLine();

		System.out.print("Enter teamwork task description (Press enter to skip): ");
		String description = scanner.nextLine();

		TeamWorkTask newTask = new TeamWorkTask(id, name, description, teamName);

		if (taskManager.addTask(newTask)) {
			System.out.println("Teamwork Task added successfully!");
		} else {
			System.out.println("Task not added. Teamwork task with the same ID already exists.");
		}
	}

	private static void removeTask(TaskManager taskManager, Scanner scanner) {
		System.out.print("Enter the ID number of the task to remove: ");
		int taskId = getPositiveIntegerInput(scanner);

		if (taskId == -1) {
			return;
		}

		if (taskManager.removeTask(taskId)) {
			System.out.println("Task removed successfully!");
		} else {
			System.out.println("No task removed. Task with the given ID number is not found.");
		}
	}

	private static int getPositiveIntegerInput(Scanner scanner) {
		int err = 0; //no input error yet 

		while (true) {
			try {
				String input = scanner.next();

				if (input.matches("^[1-9][0-9]*$")) { //regular expression (^ = start, [1-9] any no from 1-9, same for [0-9], * = 0 or more times, $ = end)
					return Integer.parseInt(input);
				} else {
					if (input.equalsIgnoreCase("H") && err == 1) { //if there is a
						return -1; // or any other value to indicate an error
					} else {
						System.out.println("Invalid input. Please enter a positive whole number.");
						System.out.print("Enter (H) to return to the homepage, or retry your request.");
						err = 1;
					}
				}
			} catch (java.util.InputMismatchException e) {
				System.out.println("Invalid input. Please enter a positive whole number.");
				scanner.nextLine(); // Consume the invalid input
				System.out.print("Enter (H) to return to the homepage, or retry your request.");
				String goBackChoice = scanner.next();

				if (goBackChoice.equalsIgnoreCase("H")) {
					return -1; // or any other value to indicate an error
				}
			}
		}
	}

}
