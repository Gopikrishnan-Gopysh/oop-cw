📖 Overview

This project is a Task Management System developed in Java as part of the F28HS Object-Oriented Programming coursework. The application allows users to manage a list of different task types through a simple text-based user interface. It follows OOP principles such as encapsulation, inheritance, abstraction, cohesion, and low coupling, which are reflected throughout the code and explained via comments.

✨ Features

Manage tasks of different types:
PersonalTask
WorkTask
TeamWorkTask
Add, remove, and display tasks.
Save and load tasks from a file on the hard disk.
Reminder system for Work and TeamWork tasks via a Remindable interface.
Unit testing with JUnit.
Text-based menu interface for easy interaction.
📌 Project Structure

├── src/
│   ├── Task.java               (abstract base class)
│   ├── PersonalTask.java       (subclass of Task)
│   ├── WorkTask.java           (subclass of Task + Remindable)
│   ├── TeamWorkTask.java       (subclass of WorkTask)
│   ├── TaskManager.java        (extends ArrayList, manages task list)
│   ├── Remindable.java         (interface)
│   └── Main.java               (user interface and main program loop)
├── test/
│   └── TaskManagerTest.java    (JUnit test cases)
├── tasks.txt                   (sample task data file)
├── README.md                   (this file)
💾 How to Run

Clone the repository:
git clone https://github.com/yourusername/task-management-system.git
cd task-management-system
Compile the project:
javac src/*.java
Run the program:
java src/Main
🧪 How to Run Tests

Make sure JUnit is configured in your environment.

javac -cp .:junit-4.13.2.jar:hamcrest-core-1.3.jar test/TaskManagerTest.java
java -cp .:junit-4.13.2.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore TaskManagerTest
📈 Development Timeline (Commit History)

This project was developed incrementally with a clear breakdown per coursework week:

Week 1-2: Task and TaskManager class creation, basic UI.
Week 3: Unit testing for add/remove functionality.
Week 4: Task hierarchy implementation, extended UI, and updated tests.
Week 5: Abstract Task class, Remindable interface, file I/O, and final test adjustments.
📖 Skills Gained

Top skills developed through this project:

Object-Oriented Programming (OOP) — Applying core principles like inheritance, abstraction, and interfaces.
Java Collections and Generics — Managing dynamic task lists and extending collection classes.
File Input/Output — Reading and writing structured data to files.
JUnit Testing — Creating unit tests covering both positive and negative cases.
Incremental Development with Git — Structuring commits for modular, trackable progress.
📜 Notes

All classes include comments addressing cohesion, coupling, and OOP practices.
The project follows the submission and academic integrity guidelines as outlined by the university.
📚 Reference

Heriot-Watt University Academic Integrity
W3Schools Java User Input
📌 Author

H00434627 — Gopikrishnan Krishna
