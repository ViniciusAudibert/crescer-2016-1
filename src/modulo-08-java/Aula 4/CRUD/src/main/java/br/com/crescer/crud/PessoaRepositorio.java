package br.com.crescer.crud;

import br.com.crescer.aula4.ConnectionsUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PessoaRepositorio implements IPessoaRepositorio {

    @Override
    public void insert(Pessoa pessoa) {

        final String INSERT = "INSERT INTO PESSOA("
                + "ID_PESSOA, NM_PESSOA ) "
                + "VALUES ((SELECT MAX(ID_PESSOA) + 1 FROM PESSOA), ?)";

        try (final Connection connection = ConnectionsUtils.getConnection()) {

            try (final PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {
                preparedStatement.setString(1, pessoa.getNome());
                preparedStatement.executeUpdate();
            } catch (final SQLException e) {
                System.err.format("SQLException: %s", e);
            }

        } catch (SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

    @Override
    public void update(Pessoa pessoa) {
        final String UPDATE = "UPDATE PESSOA SET"
                + " NM_PESSOA = ?"
                + " WHERE ID_PESSOA = ?";

        try (final Connection connection = ConnectionsUtils.getConnection()) {

            try (final PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {
                preparedStatement.setString(1, pessoa.getNome());
                preparedStatement.setInt(2, pessoa.getId());

                preparedStatement.executeUpdate();
            } catch (final SQLException e) {
                System.err.format("SQLException: %s", e);
            }

        } catch (SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

    @Override
    public void delete(int id) {
        final String DELETE = "DELETE FROM PESSOA"
                + " WHERE ID_PESSOA = ?";

        try (final Connection connection = ConnectionsUtils.getConnection()) {

            try (final PreparedStatement preparedStatement = connection.prepareStatement(DELETE)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
            } catch (final SQLException e) {
                System.err.format("SQLException: %s", e);
            }

        } catch (SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

    @Override
    public List<Pessoa> listAll() {
        ArrayList<Pessoa> listPessoas = new ArrayList<>();

        final String query = "SELECT * FROM PESSOA";

        try (final Connection connection = ConnectionsUtils.getConnection()) {

            try (final Statement statement = connection.createStatement()) {
                try (final ResultSet resultSet = statement.executeQuery(query)) {
                    while (resultSet.next()) {
                        listPessoas.add(new Pessoa(resultSet.getInt("ID_PESSOA"),
                                resultSet.getString("NM_PESSOA")));
                    }
                } catch (final SQLException e) {
                    System.err.format("SQLException: %s", e);
                }
            } catch (final SQLException e) {
                System.err.format("SQLException: %s", e);
            }

        } catch (SQLException e) {
            System.err.format("SQLException: %s", e);
        }
        return listPessoas;
    }

    @Override
    public List<Pessoa> findNome(String nome) {
        ArrayList<Pessoa> listPessoas = new ArrayList<>();

        final String QUERY = "SELECT * FROM PESSOA WHERE LOWER(NM_PESSOA) LIKE LOWER(?)";

        try (final Connection connection = ConnectionsUtils.getConnection()) {
            try (final PreparedStatement preparedStatement = connection.prepareStatement(QUERY)) {
                preparedStatement.setString(1, "%" + nome + "%");
                preparedStatement.executeUpdate();
                try (final ResultSet resultSet = preparedStatement.executeQuery(QUERY)) {
                    while (resultSet.next()) {
                        listPessoas.add(new Pessoa(resultSet.getInt("ID_PESSOA"),
                                resultSet.getString("NM_PESSOA")));
                    }
                } catch (final SQLException e) {
                    System.err.format("SQLException: %s", e);
                }
            } catch (final SQLException e) {
                System.err.format("SQLException: %s", e);
            }

        } catch (SQLException e) {
            System.err.format("SQLException: %s", e);
        }
        return listPessoas;
    }

    public static void main(String[] args) {
        PessoaRepositorio pessoaRepositorio = new PessoaRepositorio();

        List<Pessoa> pes = pessoaRepositorio.findNome("registro");
        for (Pessoa pessoa : pes) {
            System.out.println(pessoa.getId() + " - " + pessoa.getNome());
        }
    }

}
