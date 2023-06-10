package org.example.ClassesForQueries;

public class ProjectPrices {
    private int projectId;
    private int projectCost;

    public ProjectPrices(int projectId, int projectCost) {
        this.projectId = projectId;
        this.projectCost = projectCost;
    }

    @Override
    public String toString() {
        return "ProjectPrices{" +
                "projectId=" + projectId +
                ", projectCost=" + projectCost +
                '}';
    }
}
