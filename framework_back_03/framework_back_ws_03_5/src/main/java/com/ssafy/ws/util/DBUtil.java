package com.ssafy.ws.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DBUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/ssafydb?serverTimezone=UTC";
    private static final String USER = "ssafy";
    private static final String PASSWORD = "ssafy";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void close(AutoCloseable... closeables) {
        for (AutoCloseable c : closeables) {
            if (c != null) {
                try {
                    c.close();
                } catch (Exception ignore) {}
            }
        }
    }
}
