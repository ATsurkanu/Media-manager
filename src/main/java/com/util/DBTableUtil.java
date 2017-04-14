package com.util;

import java.sql.Connection;
import java.sql.SQLException;

public class DBTableUtil {

    private static Connection connection;

    public static void createBookTable() {
        String sqlCreate = "CREATE TABLE IF NOT EXISTS books"
                + "  (id           SERIAL PRIMARY KEY,"
                + "   books        VARCHAR,";
        try {
            connection.createStatement().execute(sqlCreate);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void createMovieTable() {
        String sqlCreate = "CREATE TABLE IF NOT EXISTS movies"
                + " ( id            SERIAL PRIMARY KEY,"
                + "   movies        VARCHAR ,";
        try {
            connection.createStatement().execute(sqlCreate);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createMusicTable() {
        String sqlCreate = "CREATE TABLE IF NOT EXISTS musics"
                + " (id          SERIAL PRIMARY KEY,"
                + "  musics      VARCHAR ,";
        try {
            connection.createStatement().execute(sqlCreate);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
