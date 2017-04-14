package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBConnectionUtil {

    public Connection connect(String host, String username, String password) {
        try {
            Class.forName("org.postgresql.Driver");
            String url = host;
            Properties properties = new Properties();
            properties.setProperty("user", username);
            properties.setProperty("password", password);
            return DriverManager.getConnection(url, properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

     public Connection connect() {
        return this.connect("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
    }
}