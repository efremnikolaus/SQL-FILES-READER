package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseInitService {
    private static final String FILE_PATH_INIT_DB = "src/sql/init_db.sql";
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PATH_INIT_DB))) {
            String line;
            while((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(System.lineSeparator());
            }
        } catch (IOException ex) {
            System.out.println("Troubles with Init Service: " + ex.getMessage());
            ex.printStackTrace();
        }

        try (Connection connection = DatabaseH2.getInstance().getConnection()) {
            String[] queries = stringBuilder.toString().split(";");

            for (String query : queries) {
                query = query.trim();
                if (!query.isEmpty()) {
                    connection.createStatement().executeUpdate(query);
                }
            }
            System.out.println("Database successfully initialized!");
        } catch (SQLException ex) {
            System.out.println("Error querying database: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}