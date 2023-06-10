package org.example;

import org.example.ClassesForQueries.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
    private static final String FIND_LONGEST_PROJECTS = "src/sql/find_longest_projects.sql";
    private static final String FIND_MAX_PROJECTS_CLIENT = "src/sql/find_max_projects_client.sql";
    private static final String FIND_MAX_SALARY_WORKER = "src/sql/find_max_salary_worker.sql";
    private static final String FIND_YOUNGEST_ELDEST_WORKERS = "src/sql/find_youngest_eldest_workers.sql";
    private static final String PRINT_PROJECT_PRICES = "src/sql/print_project_prices.sql";
    public List<LongestProjects> findLongestProjects() {
        List<LongestProjects> result = new ArrayList<>();
        try {
            Connection connection = DatabaseH2.getInstance().getConnection();
            String sqlQuery = Files.readString(Paths.get(FIND_LONGEST_PROJECTS));
            ResultSet resultSet = connection.createStatement().executeQuery(sqlQuery);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int clientId = resultSet.getInt("client_id");
                String startDate = resultSet.getString("start_date");
                String finishDate = resultSet.getString("finish_date");
                result.add(new LongestProjects(id, clientId, startDate, finishDate));
            }
        } catch (IOException | SQLException ex) {
            System.out.println("Error selecting database: " + ex.getMessage());
            ex.printStackTrace();
        }
        System.out.println(result);
        return result;
    }
    public List<MaxProjectCountClient> findMaxProjectsClient() {
        List<MaxProjectCountClient> result = new ArrayList<>();
        try {
            Connection connection = DatabaseH2.getInstance().getConnection();
            String sqlQuery = Files.readString(Paths.get(FIND_MAX_PROJECTS_CLIENT));
            ResultSet resultSet = connection.createStatement().executeQuery(sqlQuery);

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int projectCount = resultSet.getInt("id");
                result.add(new MaxProjectCountClient(name, projectCount));
            }
        } catch (IOException | SQLException ex) {
            System.out.println("Error selecting database: " + ex.getMessage());
            ex.printStackTrace();
        }
        System.out.println(result);
        return result;
    }
    public List<MaxSalaryWorker> findMaxSalaryWorker() {
        List<MaxSalaryWorker> result = new ArrayList<>();
        try {
            Connection connection = DatabaseH2.getInstance().getConnection();
            String sqlQuery = Files.readString(Paths.get(FIND_MAX_SALARY_WORKER));
            ResultSet resultSet = connection.createStatement().executeQuery(sqlQuery);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String birthday = resultSet.getString("birthday");
                String level = resultSet.getString("level");
                int salary = resultSet.getInt("salary");
                result.add(new MaxSalaryWorker(id, name, birthday, level, salary));
            }
        } catch (IOException | SQLException ex) {
            System.out.println("Error selecting database: " + ex.getMessage());
            ex.printStackTrace();
        }
        System.out.println(result);
        return result;
    }
    public List<YoungestEldestWorkers> findYoungestEldestWorkers() {
    List<YoungestEldestWorkers> result = new ArrayList<>();
        try {
            Connection connection = DatabaseH2.getInstance().getConnection();
            String sqlQuery = Files.readString(Paths.get(FIND_YOUNGEST_ELDEST_WORKERS));
            ResultSet resultSet = connection.createStatement().executeQuery(sqlQuery);

            while (resultSet.next()) {
                String type = resultSet.getString("type");
                String name = resultSet.getString("name");
                String birthday = resultSet.getString("birthday");
                result.add(new YoungestEldestWorkers(type, name, birthday));
            }
        } catch (IOException | SQLException ex) {
            System.out.println("Error selecting database: " + ex.getMessage());
            ex.printStackTrace();
        }
        System.out.println(result);
        return result;
        }
      public List<ProjectPrices> printProjectPrices() throws IOException {
          String sqlQuery = Files.readString(Paths.get(PRINT_PROJECT_PRICES));
          List<ProjectPrices> result = new ArrayList<>();
          try (Connection connection = DatabaseH2.getInstance().getConnection();
               ResultSet resultSet = connection.createStatement().executeQuery(sqlQuery);) {
              while (resultSet.next()) {
                  int projectId = resultSet.getInt("project_id");
                  int projectCost = resultSet.getInt("project_cost");
                  result.add(new ProjectPrices(projectId, projectCost));
              }
          } catch (SQLException ex) {
              System.out.println("Error selecting database: " + ex.getMessage());
              ex.printStackTrace();
          }
          System.out.println(result);
          return result;
      }

    public static void main(String[] args) throws IOException {
        List<LongestProjects> longestProjectsList = new DatabaseQueryService().findLongestProjects();
        List<MaxProjectCountClient> maxProjectCountClients = new DatabaseQueryService().findMaxProjectsClient();
        List<MaxSalaryWorker> maxSalaryWorkers = new DatabaseQueryService().findMaxSalaryWorker();
        List<YoungestEldestWorkers> youngestEldestWorkers = new DatabaseQueryService().findYoungestEldestWorkers();
        List<ProjectPrices> projectPrices = new DatabaseQueryService().printProjectPrices();
    }
}
