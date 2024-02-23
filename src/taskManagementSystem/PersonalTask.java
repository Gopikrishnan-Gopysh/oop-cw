package taskManagementSystem;

// Subclass of Task representing personal tasks
public class PersonalTask extends Task implements Remindable {
    public PersonalTask(int id, String name, String description) {
        super(id, name, description, "Personal");
    }

    public void remindUser() {
        System.out.println("Personal task: " + getName());
    }
}