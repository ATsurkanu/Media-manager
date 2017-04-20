package com.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTableUtil {

    public static void createBooksTable(Connection connection) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS BOOKS(ID INT NOT NULL AUTO_INCREMENT, " +
                    "BOOK VARCHAR(255) NOT NULL, STATUS VARCHAR(255))");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
//        String sqlCreate = "CREATE TABLE IF NOT EXISTS books"
//                + "  (id           SERIAL PRIMARY KEY,"
//                + "   books        VARCHAR,";
//        try {
//            connection.createStatement().execute(sqlCreate);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
// }


    public static void createMoviesTable(Connection connection) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS MOVIES(ID INT NOT NULL AUTO_INCREMENT, " +
                    "MOVIE VARCHAR(255) NOT NULL, STATUS VARCHAR (255))");
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        String sqlCreate = "CREATE TABLE IF NOT EXISTS movies"
//                + " ( id            SERIAL PRIMARY KEY,"
//                + "   movies        VARCHAR ,";
//        try {
//            connection.createStatement().execute(sqlCreate);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    public static void createMusicsTable(Connection connection) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS MUSICS(ID INT NOT NULL AUTO_INCREMENT, " +
                    "MUSIC VARCHAR(255) NOT NULL, STATUS VARCHAR(255))");
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        String sqlCreate = "CREATE TABLE IF NOT EXISTS musics"
//                + " (id          SERIAL PRIMARY KEY,"
//                + "  musics      VARCHAR ,";
//        try {
//            connection.createStatement().execute(sqlCreate);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

}
