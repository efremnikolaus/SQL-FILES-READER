package org.example;

import org.example.ClassesForQueries.MaxProjectCountClient;

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
    public List<MaxProjectCountClient> findMaxProjectsClient() {
        try {
            Connection connection = DatabaseH2.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(FIND_MAX_PROJECTS_CLIENT);

            List<MaxProjectCountClient> result = new ArrayList<>();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int projectCount = resultSet.getInt("project_count");
                result.add(new MaxProjectCountClient(name, projectCount));
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException ex) {
            System.out.println("Error selecting database: " + ex.getMessage());
            ex.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        List<MaxProjectCountClient> maxProjectCountClients = new DatabaseQueryService().findMaxProjectsClient();
    }
}
