package org.example.ClassesForQueries;

public class LongestProjects {
    private int id;
    private int months;

    public LongestProjects(int id, int months) {
        this.id = id;
        this.months = months;
    }

    @Override
    public String toString() {
        return "LongestProjects{" +
                "id=" + id +
                ", months=" + months +
                '}';
    }
}
