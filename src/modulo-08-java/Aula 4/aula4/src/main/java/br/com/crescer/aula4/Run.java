package br.com.crescer.aula4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Run {

    public static void main(String[] args) {
        final String insert = "INSERT INTO PESSOA("
                + "ID_PESSOA, NM_PESSOA ) "
                + "VALUES ((SELECT MAX(ID_PESSOA) + 1 FROM PESSOA), ?)";
        try (final Connection connection = ConnectionsUtils.getConnection()) {
            try (final PreparedStatement preparedStatement = connection.prepareStatement(insert)) {
                    preparedStatement.setString(1, "");
                    preparedStatement.executeUpdate();
            } catch (final SQLException e) {
                System.err.format("SQLException: %s", e);
            }
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }
}
