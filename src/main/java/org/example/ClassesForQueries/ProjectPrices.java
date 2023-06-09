package org.example.ClassesForQueries;

public class ProjectPrices {
    private String name;
    private String projectPrices;

    public ProjectPrices(String name, String projectPrices) {
        this.name = name;
        this.projectPrices = projectPrices;
    }

    @Override
    public String toString() {
        return "ProjectPrices{" +
                "name='" + name + '\'' +
                ", projectPrices='" + projectPrices + '\'' +
                '}';
    }
}
