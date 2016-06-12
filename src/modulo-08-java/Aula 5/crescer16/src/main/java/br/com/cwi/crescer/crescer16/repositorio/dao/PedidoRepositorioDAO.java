package br.com.cwi.crescer.crescer16.repositorio.dao;

import br.com.cwi.crescer.crescer16.entity.Cidade;
import br.com.cwi.crescer.crescer16.entity.Pedido;
import br.com.cwi.crescer.crescer16.irepositorio.IPedidoRepositorio;
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
public class PedidoRepositorioDAO implements IPedidoRepositorio {
    
    private static final String INSERT_PEDIDO = "INSERT INTO PEDIDO (IDPEDIDO, "
            + "IDCLIENTE, "
            + "DATAPEDIDO, "
            + "DATAENTREGA, "
            + "VALORPEDIDO, "
            + "SITUACAO) "
            + "VALUES ((SELECT NVL(MAX(IDPEDIDO), 0) + 1 FROM PEDIDO), ?, ?, ?, ?, ?)";
    private static final String UPDATE_PEDIDO = "UPDATE PEDIDO SET "
            + "IDCLIENTE = ?, "
            + "DATAPEDIDO = ?, "
            + "DATAENTREGA = ?, "
            + "VALORPEDIDO = ?, "
            + "SITUACAO = ? "
            + "WHERE IDPEDIDO = ?";
    private static final String DELETE_PEDIDO = "DELETE PEDIDO WHERE IDPEDIDO = ?";
    private static final String LIST_ALL_PEDIDO = "SELECT * FROM PEDIDO";
    
    private final Connection connection;
    
    public PedidoRepositorioDAO(Connection connection) {
        this.connection = connection;
    }
    
    @Override
    public void insert(Pedido pedido) {
        try (final PreparedStatement prepareStatement = connection.prepareStatement(INSERT_PEDIDO);) {
            prepareStatement.setInt(1, pedido.getIdCliente());
            prepareStatement.setDate(2, (Date) pedido.getDataPedido());
            prepareStatement.setDate(3, (Date) pedido.getDataEntrega());
            prepareStatement.setBigDecimal(4, pedido.getValorPedido());
            prepareStatement.setString(5, String.valueOf(pedido.getSituacao()));
            prepareStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }
    
    @Override
    public int delete(int id) {
        try (final PreparedStatement prepareStatement = connection.prepareStatement(DELETE_PEDIDO);) {
            prepareStatement.setInt(1, id);
            prepareStatement.executeUpdate();
            return id;
        } catch (SQLException e) {
            System.err.format("SQLException: %s", e);
            return -1;
        }
    }
    
    @Override
    public int update(Pedido pedido) {
        try (final PreparedStatement prepareStatement = connection.prepareStatement(UPDATE_PEDIDO);) {
            prepareStatement.setInt(1, pedido.getIdCliente());
            prepareStatement.setDate(2, (Date) pedido.getDataPedido());
            prepareStatement.setDate(3, (Date) pedido.getDataEntrega());
            prepareStatement.setBigDecimal(4, pedido.getValorPedido());
            prepareStatement.setString(5, String.valueOf(pedido.getSituacao()));
            prepareStatement.setInt(6, pedido.getIdPedido());
            prepareStatement.executeUpdate();
            return pedido.getIdPedido();
        } catch (SQLException e) {
            System.err.format("SQLException: %s", e);
            return -1;
        }
    }
    
    @Override
    public List<Pedido> toList() {
        List<Pedido> pedidos = new ArrayList();
        try (final Statement statement = connection.createStatement();
                final ResultSet resultSet = statement.executeQuery(LIST_ALL_PEDIDO);) {
            
            while (resultSet.next()) {
                final Pedido pedido = new Pedido();
                pedido.setIdPedido(resultSet.getInt("IDPEDIDO"));
                pedido.setIdCliente(resultSet.getInt("IDCLIENTE"));
                pedido.setDataPedido(resultSet.getDate("DATAPEDIDO"));
                pedido.setDataEntrega(resultSet.getDate("DATAENTREGA"));
                pedido.setValorPedido(resultSet.getBigDecimal("VALORPEDIDO"));
                pedido.setSituacao(resultSet.getString("SITUACAO").charAt(0));
                pedidos.add(pedido);
            }
            
        } catch (SQLException e) {
            System.err.format("SQLException: %s", e);
        }
        return pedidos;
    }
    
}
