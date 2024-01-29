package taskManagementSystem;


//Declaring the required arrays
public class Task {
 private int id;
 private String name;
 private String description;

 // Constructor with mandatory fields
 public Task(int id, String name) {
     this.id = id;
     this.name = name;
 }

 // Constructor with all fields
 public Task(int id, String name, String description) {
     this(id, name);
     this.description = description;
 }

 // Getters for the fields
 public int getId() {
     return id;
 }

 public String getName() {
     return name;
 }

 public String getDescription() {
     return description;
 }
}
