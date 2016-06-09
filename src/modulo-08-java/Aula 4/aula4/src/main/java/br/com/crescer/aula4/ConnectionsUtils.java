package br.com.crescer.aula4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionsUtils {

    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "CRESCER16";
    private static final String PASS = "CRESCER16";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
