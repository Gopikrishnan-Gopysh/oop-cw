package taskManagementSystem;

// Subclass of Task representing personal tasks
public class PersonalTask extends Task {
    public PersonalTask(int id, String name, String description) {
    	 super(id, name, description, "Personal");
    }
}