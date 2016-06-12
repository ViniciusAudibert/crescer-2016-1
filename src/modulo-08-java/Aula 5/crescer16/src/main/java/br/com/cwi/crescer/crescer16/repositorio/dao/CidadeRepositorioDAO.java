package br.com.cwi.crescer.crescer16.repositorio.dao;

import br.com.cwi.crescer.crescer16.entity.Cidade;
import br.com.cwi.crescer.crescer16.irepositorio.ICidadeRepositorio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vinicius
 */
public class CidadeRepositorioDAO implements ICidadeRepositorio {

    private static final String INSERT_CIDADE = "INSERT INTO CIDADE (IDCIDADE, NOME, UF) VALUES ((SELECT NVL(MAX(IDCIDADE), 0) + 1 FROM CIDADE), ?, ?)";
    private static final String UPDATE_CIDADE = "UPDATE CIDADE SET NOME = ?, UF = ? WHERE IDCIDADE = ?";
    private static final String DELETE_CIDADE = "DELETE CIDADE WHERE IDCIDADE = ?";
    private static final String LIST_ALL_CIDADE = "SELECT * FROM CIDADE";

    private final Connection connection;

    public CidadeRepositorioDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Cidade cidade) {
        try (final PreparedStatement prepareStatement = connection.prepareStatement(INSERT_CIDADE);) {
            prepareStatement.setString(1, cidade.getNome());
            prepareStatement.setString(2, cidade.getUf());
            prepareStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

    @Override
    public int delete(int id) {
        try (final PreparedStatement prepareStatement = connection.prepareStatement(DELETE_CIDADE);) {
            prepareStatement.setInt(1, id);
            prepareStatement.executeUpdate();
            return id;
        } catch (SQLException e) {
            System.err.format("SQLException: %s", e);
            return -1;
        }
    }

    @Override
    public int update(Cidade cidade) {
        try (final PreparedStatement prepareStatement = connection.prepareStatement(UPDATE_CIDADE);) {
            prepareStatement.setString(1, cidade.getNome());
            prepareStatement.setString(2, cidade.getUf());
            prepareStatement.setInt(3, cidade.getIdCidade());
            prepareStatement.executeUpdate();
            return cidade.getIdCidade();
        } catch (SQLException e) {
            System.err.format("SQLException: %s", e);
            return -1;
        }
    }

    @Override
    public List<Cidade> toList() {
        List<Cidade> cidades = new ArrayList();
        try (final Statement statement = connection.createStatement();
                final ResultSet resultSet = statement.executeQuery(LIST_ALL_CIDADE);) {

            while (resultSet.next()) {
                final Cidade cidade = new Cidade();
                cidade.setIdCidade(resultSet.getInt("IDCIDADE"));
                cidade.setNome(resultSet.getString("NOME"));
                cidade.setUf(resultSet.getString("UF"));
                cidades.add(cidade);
            }

        } catch (SQLException e) {
            System.err.format("SQLException: %s", e);
        }
        return cidades;
    }
}
