package taskManagementSystem;

public abstract class Task {
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
    // Convert a task to a string representation
    public String taskToString() {
        return id + "," + name + "," + description + "," + hierarchy;
    }

    // Create a task from a string
    public static Task stringToTask(String taskString) {
        String[] taskData = taskString.split(",");
        int id = Integer.parseInt(taskData[0]);
        String name = taskData[1];
        String description = taskData[2];
        String hierarchy = taskData[3];

        // Create a task based on the hierarchy type
        if (hierarchy.equals("Work")) {
            return new WorkTask(id, name, description);
        } else if (hierarchy.equals("Team")) {

            String teamName = taskData[4];
            return new TeamWorkTask(id, name, description, teamName);
        } else {
           
            return new PersonalTask(id, name, description);
        }
    }
}

    
