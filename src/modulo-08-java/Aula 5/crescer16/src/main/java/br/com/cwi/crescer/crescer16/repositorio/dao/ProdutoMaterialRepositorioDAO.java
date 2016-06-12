package br.com.cwi.crescer.crescer16.repositorio.dao;

import br.com.cwi.crescer.crescer16.entity.Produto;
import br.com.cwi.crescer.crescer16.entity.ProdutoMaterial;
import br.com.cwi.crescer.crescer16.irepositorio.IProdutoMaterialRepositorio;
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
public class ProdutoMaterialRepositorioDAO implements IProdutoMaterialRepositorio {
private static final String INSERT_PRODUTOMATERIAL = "INSERT INTO PRODUTOMATERIAL (IDPRODUTOMATERIAL, "
            + "IDPRODUTO, "
            + "IDMATERIAL, "
            + "QUANTIDADE "
            + "VALUES ((SELECT NVL(MAX(IDPRODUTOMATERIAL), 0) + 1 FROM PRODUTOMATERIAL), ?, ?, ?)";
    private static final String UPDATE_PRODUTOMATERIAL = "UPDATE PRODUTOMATERIAL SET "
            + "IDPRODUTO = ?, "
            + "IDMATERIAL = ?, "
            + "QUANTIDADE = ?, "
            + "WHERE IDPRODUTOMATERIAL = ?";
    private static final String DELETE_PRODUTOMATERIAL = "DELETE PRODUTOMATERIAL WHERE IDPRODUTOMATERIAL = ?";
    private static final String LIST_ALL_PRODUTOMATERIAL = "SELECT * FROM PRODUTOMATERIAL";
    
    private final Connection connection;

    public ProdutoMaterialRepositorioDAO(Connection connection) {
        this.connection = connection;
    }
    
    @Override
    public void insert(ProdutoMaterial produtoMaterial) {
        try (final PreparedStatement prepareStatement = connection.prepareStatement(INSERT_PRODUTOMATERIAL);) {
            prepareStatement.setInt(1, produtoMaterial.getIdProduto());
            prepareStatement.setInt(2, produtoMaterial.getIdMaterial());
            prepareStatement.setInt(3, produtoMaterial.getQuantidade());
            prepareStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

    @Override
    public int delete(int id) {
        try (final PreparedStatement prepareStatement = connection.prepareStatement(DELETE_PRODUTOMATERIAL);) {
            prepareStatement.setInt(1, id);
            prepareStatement.executeUpdate();
            return id;
        } catch (SQLException e) {
            System.err.format("SQLException: %s", e);
            return -1;
        }
    }

    @Override
    public int update(ProdutoMaterial produtoMaterial) {
        try (final PreparedStatement prepareStatement = connection.prepareStatement(INSERT_PRODUTOMATERIAL);) {
            prepareStatement.setInt(1, produtoMaterial.getIdProduto());
            prepareStatement.setInt(2, produtoMaterial.getIdMaterial());
            prepareStatement.setInt(3, produtoMaterial.getQuantidade());
            prepareStatement.setInt(4, produtoMaterial.getIdProdutoMaterial());
            prepareStatement.executeUpdate();
            return produtoMaterial.getIdProdutoMaterial();
        } catch (SQLException e) {
            System.err.format("SQLException: %s", e);
            return -1;
        }
    }

    @Override
    public List<ProdutoMaterial> toList() {
        List<ProdutoMaterial> produtosMateriais = new ArrayList();
        try (final Statement statement = connection.createStatement();
                final ResultSet resultSet = statement.executeQuery(LIST_ALL_PRODUTOMATERIAL);) {

            while (resultSet.next()) {
                final ProdutoMaterial produtoMaterial = new ProdutoMaterial();
                produtoMaterial.setIdProdutoMaterial(resultSet.getInt("IDPRODUTOMATERIAL"));
                produtoMaterial.setIdProduto(resultSet.getInt("IDPRODUTO"));
                produtoMaterial.setIdMaterial(resultSet.getInt("IDMATERIAL"));
                produtoMaterial.setQuantidade(resultSet.getInt("QUANTIDADE"));
                produtosMateriais.add(produtoMaterial);
            }

        } catch (SQLException e) {
            System.err.format("SQLException: %s", e);
        }
        return produtosMateriais;
    }  
}
