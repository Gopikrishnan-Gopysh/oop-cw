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
    public String getHierarchy() {
        return hierarchy;
    }
    public String getName() {
        return name;
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
        return id + "," + hierarchy + "," + name + "," + description;
    }

    // Create a task from a string
    public static Task stringToTask(String taskString) {
        String[] taskData = taskString.split(",");
        int id = Integer.parseInt(taskData[0]);
        String hierarchy = taskData[1];
        String name = taskData[2];
        String description = taskData[3];
        
        System.out.println("Hello :" + hierarchy);

        // Create a task based on the hierarchy type
        if (hierarchy.equals("Work")) {
            System.out.println("Hello1 :" + hierarchy);
            return new WorkTask(id, name, description);
        } else if (hierarchy.equals("Teamwork")) {
            String teamName = taskData[4];
            System.out.println("Hello2 :" + hierarchy);            
            return new TeamWorkTask(id, name, teamName, description);
        } else {
            return new PersonalTask(id, name, description);
        }
    }
}

    
