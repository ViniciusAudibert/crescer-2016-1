package br.com.crescer.tema;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MeuSQLUtils {

    public static void execultarSQL(String path) throws FileNotFoundException, IOException, IllegalArgumentException {
        File file = new File(path);
        if (!file.exists()) {
            throw new FileNotFoundException();
        }
        if (!file.getAbsoluteFile().toString().endsWith(".sql")) {
            throw new IllegalArgumentException();
        }
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);

        String line = buffer.readLine();
        while (line != null) {
            execultarNoBanco(line);
            line = buffer.readLine();
        }
    }

    /**
     *
     * Lista retorna outras duas listas posicao 0: Nome das colunas posicao 1:
     * Primeira metade id e segunda nomes
     *
     */
    public static List<List<String>> listarColunasELinhas(String comando) {
        ArrayList<List<String>> arrayList = new ArrayList<>();
        ArrayList<String> rowIDList = new ArrayList<>();
        ArrayList<String> rowNameList = new ArrayList<>();

        try (final Connection connection = ConnectUtils.getConnection()) {
            try (final Statement statement = connection.createStatement()) {
                try (final ResultSet resultSet = statement.executeQuery(comando)) {
                    ResultSetMetaData resultSetMT = resultSet.getMetaData();

                    String col1 = resultSetMT.getColumnName(1);
                    String col2 = resultSetMT.getColumnName(2);

                    arrayList.add(new ArrayList<>(Arrays.asList(col1, col2)));
                    while (resultSet.next()) {
                        rowIDList.add("" + resultSet.getInt("ID_PESSOA"));
                        rowNameList.add(resultSet.getString("NM_PESSOA"));
                    }

                    arrayList.add(rowIDList);
                    arrayList.add(rowNameList);

                } catch (final SQLException e) {
                    System.err.format("SQLException: %s", e);
                }
            } catch (final SQLException e) {
                System.err.format("SQLException: %s", e);
            }
        } catch (SQLException e) {
            System.err.format("SQLException: %s", e);
        }
        return arrayList;
    }

    public static void importCSV(String path) throws FileNotFoundException, IllegalArgumentException, IOException {
        File file = new File(path);
        if (!file.exists()) {
            throw new FileNotFoundException();
        }
        if (!file.getAbsoluteFile().toString().endsWith(".csv")) {
            throw new IllegalArgumentException();
        }

        ArrayList<String[]> comandosList = new ArrayList<>();
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);

        String line = buffer.readLine();
        while (line != null) {
            comandosList.add(line.split(";"));
            line = buffer.readLine();
        }

        final String INSERT = "INSERT INTO PESSOA("
                + "ID_PESSOA, NM_PESSOA ) "
                + "VALUES ?, ?)";

        try (final Connection connection = ConnectUtils.getConnection()) {
            try (final PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {
                for (String[] strings : comandosList) {
                    preparedStatement.setInt(1, Integer.parseInt(strings[0]));
                    preparedStatement.setString(2, strings[1]);
                    preparedStatement.executeUpdate();
                }
            } catch (final SQLException e) {
                System.err.format("SQLException: %s", e);
            }

        } catch (SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

    public static void exportCSV(String path) throws IllegalArgumentException, IOException {
        File file = new File(path);

        if (!file.getAbsoluteFile().toString().endsWith(".csv")) {
            throw new IllegalArgumentException();
        }

        FileWriter writer = new FileWriter(file);
        BufferedWriter buffer = new BufferedWriter(writer);

        ArrayList<List<String>> linhas = (ArrayList<List<String>>) listarColunasELinhas("SELECT * FROM PESSOA");

        ArrayList<String> colunas = (ArrayList<String>) linhas.get(0);
        ArrayList<String> linhasID = (ArrayList<String>) linhas.get(1);
        ArrayList<String> linhasNM = (ArrayList<String>) linhas.get(2);

        buffer.write(colunas.get(0) + ";" + colunas.get(1));
        buffer.newLine();
        buffer.flush();

        for (int i = 0; i < linhasID.size(); i++) {
            buffer.write(linhasID.get(i) + ";" + linhasNM.get(i));
            buffer.newLine();
            buffer.flush();
        }
    }

    private static void execultarNoBanco(String comando) {
        try (final Connection connection = ConnectUtils.getConnection()) {
            try (final Statement statement = connection.createStatement()) {
                statement.executeUpdate(comando);
            } catch (final SQLException e) {
                System.err.format("SQLException: %s", e);
            }
        } catch (SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

    public static void main(String[] args) {
        try {
            execultarSQL("comandosSQL.sql");

            ArrayList<List<String>> colunasELinhas = (ArrayList<List<String>>) listarColunasELinhas("SELECT * FROM PESSOA");

            ArrayList<String> colunas = (ArrayList<String>) colunasELinhas.get(0);
            ArrayList<String> linhasID = (ArrayList<String>) colunasELinhas.get(1);
            ArrayList<String> linhasNM = (ArrayList<String>) colunasELinhas.get(2);

            System.out.println(colunas.get(0) + " | " + colunas.get(1));

            for (int i = 0; i < linhasID.size(); i++) {
                System.out.println(linhasID.get(i) + "              " + linhasNM.get(i));
            }

            //importCSV("backup1.csv");
            exportCSV("newBackup.csv");

        } catch (FileNotFoundException e) {
            System.err.println("O arquivo não existe");
        } catch (IllegalArgumentException e) {
            System.err.println("O arquivo solicitado é incompatível");
        } catch (IOException e) {
            System.err.println("Erro ao realizar este comando");
        } catch (Exception e) {
            System.err.println("Ocorreu um erro: " + e.getMessage());
        }
    }
}
