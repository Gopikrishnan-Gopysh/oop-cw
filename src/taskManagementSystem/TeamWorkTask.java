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

    // Override the generateTextRepresentation method
    @Override
    public String generateTextRepresentation() {
        return "Teamwork Task: [ID=" + getId() + ", Name=" + getName() + ", Description=" + getDescription() +
                ", Team Name=" + getTeamName() + "]";
    }
}