package br.com.cwi.crescer.crescer16.repositorio.dao;

import br.com.cwi.crescer.crescer16.entity.Cidade;
import br.com.cwi.crescer.crescer16.entity.Material;
import br.com.cwi.crescer.crescer16.irepositorio.IMaterialRepositorio;
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
public class MaterialRepositorioDAO implements IMaterialRepositorio {

    private static final String INSERT_MATERIAL = "INSERT INTO MATERIAL (IDMATERIAL, "
            + "DESCRICAO, "
            + "PESOLIQUIDO, "
            + "PRECOCUSTO) "
            + "VALUES ((SELECT NVL(MAX(IDMATERIAL), 0) + 1 FROM MATERIAL), ?, ?, ?)";
    private static final String UPDATE_MATERIAL = "UPDATE MATERIAL SET "
            + "DESCRICAO = ?, "
            + "PESOLIQUIDO = ?, "
            + "PRECOCUSTO = ? "
            + "WHERE IDMATERIAL = ?";
    private static final String DELETE_MATERIAL = "DELETE MATERIAL WHERE IDMATERIAL = ?";
    private static final String LIST_ALL_MATERIAL = "SELECT * FROM MATERIAL";

    private final Connection connection;

    public MaterialRepositorioDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Material material) {
        try (final PreparedStatement prepareStatement = connection.prepareStatement(INSERT_MATERIAL);) {
            prepareStatement.setString(1, material.getDescricao());
            prepareStatement.setBigDecimal(2, material.getPesoLiquido());
            prepareStatement.setBigDecimal(3, material.getPrecoCusto());
            prepareStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

    @Override
    public int delete(int id) {
        try (final PreparedStatement prepareStatement = connection.prepareStatement(DELETE_MATERIAL);) {
            prepareStatement.setInt(1, id);
            prepareStatement.executeUpdate();
            return id;
        } catch (SQLException e) {
            System.err.format("SQLException: %s", e);
            return -1;
        }
    }

    @Override
    public int update(Material material) {
        try (final PreparedStatement prepareStatement = connection.prepareStatement(UPDATE_MATERIAL);) {
            prepareStatement.setString(1, material.getDescricao());
            prepareStatement.setBigDecimal(2, material.getPesoLiquido());
            prepareStatement.setBigDecimal(3, material.getPrecoCusto());
            prepareStatement.setInt(4, material.getIdMaterial());
            prepareStatement.executeUpdate();
            return material.getIdMaterial();
        } catch (SQLException e) {
            System.err.format("SQLException: %s", e);
            return -1;
        }
    }

    @Override
    public List<Material> toList() {
        List<Material> materiais = new ArrayList();
        try (final Statement statement = connection.createStatement();
                final ResultSet resultSet = statement.executeQuery(LIST_ALL_MATERIAL);) {

            while (resultSet.next()) {
                final Material material = new Material();
                material.setIdMaterial(resultSet.getInt("IDMATERIAL"));
                material.setDescricao(resultSet.getString("DESCRICAO"));
                material.setPesoLiquido(resultSet.getBigDecimal("PESOLIQUIDO"));
                material.setPrecoCusto(resultSet.getBigDecimal("PRECOCUSTO"));
                materiais.add(material);
            }

        } catch (SQLException e) {
            System.err.format("SQLException: %s", e);
        }
        return materiais;
    }

}
