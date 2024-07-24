package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД

    public Connection getConnection() {
        Connection conn = null;
        String URL = "jdbc:mysql://localhost:3306/mydbtest";
        String USER = "root";
        String PASSWORD = "root";

        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Driver not found");
        }

        return conn;
    }
}
