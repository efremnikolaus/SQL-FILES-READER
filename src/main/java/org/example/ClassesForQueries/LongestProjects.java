package org.example.ClassesForQueries;

public class LongestProjects {
    private int id;
    private int clientId;
    private String startDate;
    private String finishDate;

    public LongestProjects(int id, int clientId, String startDate, String finishDate) {
        this.id = id;
        this.clientId = clientId;
        this.startDate = startDate;
        this.finishDate = finishDate;
    }
    @Override
    public String toString() {
        return "LongestProjects{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", startDate='" + startDate + '\'' +
                ", finishDate='" + finishDate + '\'' +
                '}';
    }
}
