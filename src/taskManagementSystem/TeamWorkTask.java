package taskManagementSystem;

// Subclass of WorkTask representing teamwork tasks
public class TeamWorkTask extends WorkTask implements Remindable{
    private String teamName;

    public TeamWorkTask(int id, String name, String teamName, String description) {
        super(id, name, description,"Teamwork");
        this.teamName = teamName; //"this" means the current instance of the class.
    }

    public String getTeamName() {
        return teamName;
    }
    @Override
    public String taskToString() {
        return getId() + "," + getHierarchy() + "," + getName() + "," + getDescription() + "," + this.teamName;
    }
    public String toString() {
        return "Task ID number= " + getId() + ", " + getHierarchy() + " task name= " + getName() + ", Teamname= " + this.teamName + ", Task description= " + getDescription();
    }
    // Implementation of the remindUser method from the Remindable interface
    @Override
    public void remindUser() {
        System.out.println("Teamwork task: " + getName() + " (Team: " + getTeamName() + ")");
    }
}