package org.example.ClassesForQueries;

public class ProjectPrices {
    private int projectId;
    private String projectName;
    private int projectCost;

    public ProjectPrices(int projectId, String projectName, int projectCost) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.projectCost = projectCost;
    }

    @Override
    public String toString() {
        return "ProjectPrices{" +
                "projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                ", projectCost=" + projectCost +
                '}';
    }
}
