package org.example.readers;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {
    public static String getConnectionUrlForH2() {
        try (InputStream input = PropertyReader.class.getClassLoader()
                .getResourceAsStream("application.properties")) {
            Properties properties = new Properties();
            if (input == null) {
                System.out.println("Sorry, unable to find application.properties");
                return null;
            }
            properties.load(input);
            return "jdbc:" +
                    properties.getProperty("h2.db.host") +
                    ":./" +
                    properties.getProperty("h2.db.database");
        } catch (IOException ex) {
            System.out.println("Error with SQL Filepath: " + ex.getMessage());
            ex.printStackTrace();
            return null;
        }
    }
}
