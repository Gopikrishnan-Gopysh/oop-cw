package taskManagementSystem;
public class TaskHierarchy {
    private int id;
    private String name;
    private String description;

    public TaskHierarchy(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    // Method to generate textual representation of the task
    public String generateTextRepresentation() {
        return "Task: [ID=" + id + ", Name=" + name + ", Description=" + description + "]";
    }
}