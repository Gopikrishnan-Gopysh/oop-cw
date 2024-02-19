package taskManagementSystem;

// Subclass of WorkTask representing teamwork tasks
public class TeamWorkTask extends WorkTask {
    private String teamName;

    public TeamWorkTask(int id, String name, String description, String teamName) {
        super(id, name, description);
        this.teamName = teamName;
    }

    public String getTeamName() {
        return teamName;
    }
    @Override
    public String toString() {
        return "Task ID number= " + getId() + ", Teamwork task name= " + getName() + ", Team name= " + teamName + ", Task description= " + getDescription();
    }
}