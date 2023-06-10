package org.example.ClassesForQueries;

public class MaxSalaryWorker {
    private int id;
    private String name;
    private String birthday;
    private String level;
    private int salary;

    public MaxSalaryWorker(int id, String name, String birthday, String level, int salary) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.level = level;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "MaxSalaryWorker{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                ", level='" + level + '\'' +
                ", salary=" + salary +
                '}';
    }
}
