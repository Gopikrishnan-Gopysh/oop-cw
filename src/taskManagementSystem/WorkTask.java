package taskManagementSystem;

// Subclass of Task representing work tasks
public class WorkTask extends Task implements Remindable{
    public WorkTask(int id, String name, String description) {
    	super(id, name, description, "Work");
    }
    
    public WorkTask(int id, String hierarchy, String name, String description) {
    	super(id,hierarchy, name, description);
    }
	public void remindUser() {
		System.out.println("Work task: " + getName());
	}
}