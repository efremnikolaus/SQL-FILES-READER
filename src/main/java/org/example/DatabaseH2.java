package org.example;

import org.example.readers.PropertyReader;

import java.sql.*;
import java.util.Objects;

public class DatabaseH2 {
    private static final DatabaseH2 INSTANCE = new DatabaseH2();
    private final Connection connection;
    private Statement statement;

    private DatabaseH2() {
        try {
//            String h2ConnectionURL = "jdbc:h2:./test";
            String h2ConnectionURL = PropertyReader.getConnectionUrlForH2();
            this.connection = DriverManager.getConnection(Objects.requireNonNull(h2ConnectionURL));
        } catch (SQLException ex) {
            throw new RuntimeException("Create connection exception..");
        }
    }
    public static DatabaseH2 getInstance() {
        return INSTANCE;
    }
    public Connection getConnection() {
        return connection;
    }
    public int executeUpdate(String sql) {
        try (Statement statement = connection.createStatement()) {
            return statement.executeUpdate(sql);
        } catch (Exception ex) {
            System.out.println("Error with method executeUpdate(): " + ex.getMessage());
            ex.printStackTrace();
            return -1;
        }
    }
    public ResultSet executeQuery(String sql) {
        try (Statement statement = INSTANCE.getConnection().createStatement()) {
            return statement.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println("Error with method executeQuery(): " + ex.getMessage());
            ex.printStackTrace();
            return null;
        }
    }
    public void close() {
        try {
            connection.close();
        } catch (SQLException ex) {
            System.out.println("Method close() is: " + ex.getMessage());
        }
    }
}
