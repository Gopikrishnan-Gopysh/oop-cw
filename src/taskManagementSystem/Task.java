package taskManagementSystem;
import java.util.Objects;

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
     
     if (description.strip().equals(""))	 
    	 this.description = "No description.";
     else
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

// Generates textual representation
@Override
public String toString() {
    return "Task ID number =" + id + ", Task name= " + name + ", Task description= " + description ;
}

// Equals and hashCode for comparing tasks based on ID
@Override
public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Task task = (Task) obj;
    return id == task.id;
}

@Override
public int hashCode() {
    return Objects.hash(id);
}
}
