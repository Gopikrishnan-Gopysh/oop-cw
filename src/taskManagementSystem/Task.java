package taskManagementSystem;

public class Task {
    private int id;
    private String name;
    private String hierarchy;
    private String description;

    // Constructor with mandatory fields
    public Task(int id, String name, String hierarchy) {
        this.id = id;
        this.name = name;
        this.hierarchy = hierarchy;
    }

    // Constructor with all fields
    public Task(int id, String name, String description, String hierarchy) {
        this(id, name, hierarchy);

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

    public String getHierarchy() {
        return hierarchy;
    }
    
    public String getDescription() {
        return description;
    }
 // Generates textual representation
    public String toString() {
        return "Task ID number= " + id + ", " + hierarchy + " Task name= " + name + ", Task description= " + description;
    }
}
    
