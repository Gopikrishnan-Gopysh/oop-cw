package taskManagementSystem;

// Subclass of Task representing work tasks
public class WorkTask extends Task{
    public WorkTask(int id, String name, String description) {
    	super(id, name, description, "Work");
    }
}