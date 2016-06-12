package br.com.cwi.crescer.crescer16.repositorio.dao;

import br.com.cwi.crescer.crescer16.entity.Cidade;
import br.com.cwi.crescer.crescer16.entity.Cliente;
import br.com.cwi.crescer.crescer16.irepositorio.IClienteRepositorio;
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
public class ClienteRepositorioDAO implements IClienteRepositorio {

    private static final String INSERT_CLIENTE = "INSERT INTO CLIENTE (IDCLIENTE, "
            + "NOME, "
            + "RAZAOSOCIAL, "
            + "ENDERECO, "
            + "BAIRRO, "
            + "IDCIDADE, "
            + "CEP, "
            + "SITUACAO) "
            + "VALUES ("
            + "(SELECT NVL(MAX(IDCLIENTE), 0) + 1 FROM CLIENTE), ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_CLIENTE = "UPDATE CLIENTE SET "
            + "NOME = ?, "
            + "RAZAOSOCIAL = ?, "
            + "ENDERECO = ?, "
            + "BAIRRO = ?, "
            + "IDCIDADE = ?, "
            + "CEP = ?, "
            + "SITUACAO = ?"
            + "WHERE IDCLIENTE = ?";
    private static final String DELETE_CLIENTE = "DELETE CLIENTE WHERE IDCLIENTE = ?";
    private static final String LIST_ALL_CLIENTE = "SELECT * FROM CLIENTE";

    private final Connection connection;

    public ClienteRepositorioDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Cliente cliente) {
        try (final PreparedStatement prepareStatement = connection.prepareStatement(INSERT_CLIENTE);) {
            prepareStatement.setString(1, cliente.getNome());
            prepareStatement.setString(2, cliente.getRazaoSocial());
            prepareStatement.setString(3, cliente.getEndereco());
            prepareStatement.setString(4, cliente.getBairro());
            prepareStatement.setInt(5, cliente.getIdCidade());
            prepareStatement.setLong(6, cliente.getCep());
            prepareStatement.setString(7, String.valueOf(cliente.getSituacao()));           
            prepareStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

    @Override
    public int delete(int id) {
        try (final PreparedStatement prepareStatement = connection.prepareStatement(DELETE_CLIENTE);) {
            prepareStatement.setInt(1, id);
            prepareStatement.executeUpdate();
            return id;
        } catch (SQLException e) {
            System.err.format("SQLException: %s", e);
            return -1;
        }
    }

    @Override
    public int update(Cliente cliente) {
        try (final PreparedStatement prepareStatement = connection.prepareStatement(UPDATE_CLIENTE);) {
            prepareStatement.setString(1, cliente.getNome());
            prepareStatement.setString(2, cliente.getRazaoSocial());
            prepareStatement.setString(3, cliente.getEndereco());
            prepareStatement.setString(4, cliente.getBairro());
            prepareStatement.setInt(5, cliente.getIdCidade());
            prepareStatement.setLong(6, cliente.getCep());
            prepareStatement.setString(7, String.valueOf(cliente.getSituacao()));
            prepareStatement.setInt(8, cliente.getIdCliente());
            prepareStatement.executeUpdate();
            return cliente.getIdCliente();
        } catch (SQLException e) {
            System.err.format("SQLException: %s", e);
            return -1;
        }
    }

    @Override
    public List<Cliente> toList() {
        List<Cliente> clientes = new ArrayList();
        try (final Statement statement = connection.createStatement();
                final ResultSet resultSet = statement.executeQuery(LIST_ALL_CLIENTE);) {

            while (resultSet.next()) {
                final Cliente cliente = new Cliente();
                cliente.setIdCliente(resultSet.getInt("IDCLIENTE"));
                cliente.setNome(resultSet.getString("NOME"));
                cliente.setRazaoSocial(resultSet.getString("RAZAOSOCIAL"));
                cliente.setEndereco(resultSet.getString("ENDERECO"));
                cliente.setBairro(resultSet.getString("BAIRRO"));
                cliente.setIdCidade(resultSet.getInt("IDCIDADE"));
                cliente.setCep(resultSet.getLong("CEP"));
                cliente.setSituacao(resultSet.getString("SITUACAO").charAt(0));
                clientes.add(cliente);
            }

        } catch (SQLException e) {
            System.err.format("SQLException: %s", e);
        }
        return clientes;
    }

}
