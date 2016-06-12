package br.com.cwi.crescer.crescer16.repositorio.dao;

import br.com.cwi.crescer.crescer16.entity.Cidade;
import br.com.cwi.crescer.crescer16.entity.Produto;
import br.com.cwi.crescer.crescer16.irepositorio.IProdutoRepositorio;
import java.sql.Connection;
import java.sql.Date;
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
public class ProdutoRepositorioDAO implements IProdutoRepositorio {

    private static final String INSERT_PRODUTO = "INSERT INTO PRODUTO (IDPRODUTO, "
            + "NOME, "
            + "DATACADASTRO, "
            + "PRECOCUSTO, "
            + "PRECOVENDA, "
            + "SITUACAO) "
            + "VALUES ((SELECT NVL(MAX(IDPRODUTO), 0) + 1 FROM PRODUTO), ?, ?, ?, ?, ?)";
    private static final String UPDATE_PRODUTO = "UPDATE PRODUTO SET "
            + "NOME = ?, "
            + "DATACADASTRO = ?, "
            + "PRECOCUSTO = ?, "
            + "PRECOVENDA = ?, "
            + "SITUACAO = ? "
            + "WHERE IDPRODUTO = ?";
    private static final String DELETE_PRODUTO = "DELETE PRODUTO WHERE IDPRODUTO = ?";
    private static final String LIST_ALL_PRODUTO = "SELECT * FROM PRODUTO";

    private final Connection connection;

    public ProdutoRepositorioDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Produto produto) {
        try (final PreparedStatement prepareStatement = connection.prepareStatement(INSERT_PRODUTO);) {
            prepareStatement.setString(1, produto.getNome());
            prepareStatement.setDate(2, (Date) produto.getDataCadastro());
            prepareStatement.setBigDecimal(3, produto.getPrecoCusto());
            prepareStatement.setBigDecimal(4, produto.getPrecoVenda());
            prepareStatement.setString(5, String.valueOf(produto.getSituacao()));
            prepareStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

    @Override
    public int delete(int id) {
        try (final PreparedStatement prepareStatement = connection.prepareStatement(DELETE_PRODUTO);) {
            prepareStatement.setInt(1, id);
            prepareStatement.executeUpdate();
            return id;
        } catch (SQLException e) {
            System.err.format("SQLException: %s", e);
            return -1;
        }
    }

    @Override
    public int update(Produto produto) {
        try (final PreparedStatement prepareStatement = connection.prepareStatement(UPDATE_PRODUTO);) {
            prepareStatement.setString(1, produto.getNome());
            prepareStatement.setDate(2, (Date) produto.getDataCadastro());
            prepareStatement.setBigDecimal(3, produto.getPrecoCusto());
            prepareStatement.setBigDecimal(4, produto.getPrecoVenda());
            prepareStatement.setString(5, String.valueOf(produto.getSituacao()));
            prepareStatement.setInt(6, produto.getIdProduto());
            prepareStatement.executeUpdate();
            return produto.getIdProduto();
        } catch (SQLException e) {
            System.err.format("SQLException: %s", e);
            return -1;
        }
    }

    @Override
    public List<Produto> toList() {
        List<Produto> produtos = new ArrayList();
        try (final Statement statement = connection.createStatement();
                final ResultSet resultSet = statement.executeQuery(LIST_ALL_PRODUTO);) {

            while (resultSet.next()) {
                final Produto produto = new Produto();
                produto.setIdProduto(resultSet.getInt("IDPRODUTO"));
                produto.setNome(resultSet.getString("NOME"));
                produto.setDataCadastro(resultSet.getDate("DATACADASTRO"));
                produto.setPrecoCusto(resultSet.getBigDecimal("PRECOCUSTO"));
                produto.setPrecoVenda(resultSet.getBigDecimal("PRECOVENDA"));
                produto.setSituacao(resultSet.getString("SITUACAO").charAt(0));
                produtos.add(produto);
            }

        } catch (SQLException e) {
            System.err.format("SQLException: %s", e);
        }
        return produtos;
    }
}
