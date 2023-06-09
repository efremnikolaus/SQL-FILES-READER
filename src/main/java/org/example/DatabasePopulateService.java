package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class DatabasePopulateService {
    private static final String FILE_PATH_POPULATE_DB = "src/sql/populate_db.sql";

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PATH_POPULATE_DB))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(System.lineSeparator());
            }
        } catch (IOException ex) {
            System.out.println("Troubles with Populate Service: " + ex.getMessage());
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
        } catch (SQLException ex) {
                System.out.println("Error querying database: " + ex.getMessage());
                ex.printStackTrace();
        }
    }
}
