package taskManagementSystem;

// Subclass of Task representing personal tasks
public class PersonalTask extends Task {
    public PersonalTask(int id, String name, String description) {
        super(id, name, description);
    }

    // Override the generateTextRepresentation method
    public String generateTextRepresentation() {
        return "Personal Task: [ID=" + getId() + ", Name=" + getName() + ", Description=" + getDescription() + "]";
    }
}
