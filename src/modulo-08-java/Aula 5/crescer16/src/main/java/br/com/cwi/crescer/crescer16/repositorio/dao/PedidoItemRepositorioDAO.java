package br.com.cwi.crescer.crescer16.repositorio.dao;

import br.com.cwi.crescer.crescer16.entity.PedidoItem;
import br.com.cwi.crescer.crescer16.irepositorio.IPedidoItemRepositorio;
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
public class PedidoItemRepositorioDAO implements IPedidoItemRepositorio {

    private static final String INSERT_PEDIDOITEM = "INSERT INTO PEDIDOITEM (IDPEDIDOITEM, "
            + "IDPEDIDO, "
            + "QUANTIDADE, "
            + "PRECOUNITARIO "
            + "SITUACAO "
            + "IDPRODUTO "
            + "VALUES ((SELECT NVL(MAX(IDPEDIDOITEM), 0) + 1 FROM PEDIDOITEM), ?, ?, ?, ?, ?)";
    private static final String UPDATE_PEDIDOITEM = "UPDATE PEDIDOITEM SET "
            + "IDPEDIDO = ?, "
            + "QUANTIDADE = ?, "
            + "PRECOUNITARIO = ?, "
            + "SITUACAO = ?, "
            + "IDPRODUTO = ?, "
            + "WHERE IDPEDIDOITEM = ?";
    private static final String DELETE_PEDIDOITEM = "DELETE PEDIDOITEM WHERE IDPEDIDOITEM = ?";
    private static final String LIST_ALL_PEDIDOITEM = "SELECT * FROM PEDIDOITEM";

    private final Connection connection;

    public PedidoItemRepositorioDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(PedidoItem pedidoItem) {
        try (final PreparedStatement prepareStatement = connection.prepareStatement(INSERT_PEDIDOITEM);) {
            prepareStatement.setInt(1, pedidoItem.getIdPedido());
            prepareStatement.setInt(2, pedidoItem.getQuantidade());
            prepareStatement.setBigDecimal(3, pedidoItem.getPrecoUnitario());
            prepareStatement.setString(4, String.valueOf(pedidoItem.getSituacao()));
            prepareStatement.setInt(5, pedidoItem.getIdProduto());
            prepareStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

    @Override
    public int delete(int id) {
        try (final PreparedStatement prepareStatement = connection.prepareStatement(DELETE_PEDIDOITEM);) {
            prepareStatement.setInt(1, id);
            prepareStatement.executeUpdate();
            return id;
        } catch (SQLException e) {
            System.err.format("SQLException: %s", e);
            return -1;
        }
    }

    @Override
    public int update(PedidoItem pedidoItem) {
        try (final PreparedStatement prepareStatement = connection.prepareStatement(UPDATE_PEDIDOITEM);) {
            prepareStatement.setInt(1, pedidoItem.getIdPedido());
            prepareStatement.setInt(2, pedidoItem.getQuantidade());
            prepareStatement.setBigDecimal(3, pedidoItem.getPrecoUnitario());
            prepareStatement.setString(4, String.valueOf(pedidoItem.getSituacao()));
            prepareStatement.setInt(5, pedidoItem.getIdProduto());
            prepareStatement.setInt(6, pedidoItem.getIdPedidoItem());
            prepareStatement.executeUpdate();
            return pedidoItem.getIdPedidoItem();
        } catch (SQLException e) {
            System.err.format("SQLException: %s", e);
            return -1;
        }
    }

    @Override
    public List<PedidoItem> toList() {
        List<PedidoItem> pedidosItens = new ArrayList();
        try (final Statement statement = connection.createStatement();
                final ResultSet resultSet = statement.executeQuery(LIST_ALL_PEDIDOITEM);) {

            while (resultSet.next()) {
                final PedidoItem pedidoItem = new PedidoItem();
                pedidoItem.setIdPedidoItem(resultSet.getInt("IDPEDIDOITEM"));
                pedidoItem.setIdPedido(resultSet.getInt("IDPEDIDO"));
                pedidoItem.setQuantidade(resultSet.getInt("QUANTIDADE"));
                pedidoItem.setPrecoUnitario(resultSet.getBigDecimal("PRECOUNITARIO"));
                pedidoItem.setSituacao(resultSet.getString("SITUACAO").charAt(0));
                pedidoItem.setIdProduto(resultSet.getInt("IDPRODUTO"));
                pedidosItens.add(pedidoItem);
            }

        } catch (SQLException e) {
            System.err.format("SQLException: %s", e);
        }
        return pedidosItens;
    }

}
