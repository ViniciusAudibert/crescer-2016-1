package br.com.cwi.crescer.crescer16.run;

import br.com.cwi.crescer.crescer16.csv.CSVExportador;
import br.com.cwi.crescer.crescer16.entity.Cidade;
import br.com.cwi.crescer.crescer16.entity.Cliente;
import br.com.cwi.crescer.crescer16.entity.Material;
import br.com.cwi.crescer.crescer16.entity.Pedido;
import br.com.cwi.crescer.crescer16.entity.PedidoItem;
import br.com.cwi.crescer.crescer16.entity.Produto;
import br.com.cwi.crescer.crescer16.entity.ProdutoMaterial;
import br.com.cwi.crescer.crescer16.irepositorio.ICidadeRepositorio;
import br.com.cwi.crescer.crescer16.irepositorio.IClienteRepositorio;
import br.com.cwi.crescer.crescer16.irepositorio.IMaterialRepositorio;
import br.com.cwi.crescer.crescer16.irepositorio.IPedidoItemRepositorio;
import br.com.cwi.crescer.crescer16.irepositorio.IPedidoRepositorio;
import br.com.cwi.crescer.crescer16.irepositorio.IProdutoMaterialRepositorio;
import br.com.cwi.crescer.crescer16.irepositorio.IProdutoRepositorio;
import br.com.cwi.crescer.crescer16.repositorio.dao.CidadeRepositorioDAO;
import br.com.cwi.crescer.crescer16.repositorio.dao.ClienteRepositorioDAO;
import br.com.cwi.crescer.crescer16.repositorio.dao.MaterialRepositorioDAO;
import br.com.cwi.crescer.crescer16.repositorio.dao.PedidoItemRepositorioDAO;
import br.com.cwi.crescer.crescer16.repositorio.dao.PedidoRepositorioDAO;
import br.com.cwi.crescer.crescer16.repositorio.dao.ProdutoMaterialRepositorioDAO;
import br.com.cwi.crescer.crescer16.repositorio.dao.ProdutoRepositorioDAO;
import br.com.cwi.crescer.crescer16.utils.ConnectionUtils;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vinicius
 */
public class Run {

    public static void main(String[] args) {
        try (final Connection connection = ConnectionUtils.getConnection()) {
            CSVExportador csv = new CSVExportador();
            ICidadeRepositorio cidadeRepositorio = new CidadeRepositorioDAO(connection);
            IClienteRepositorio clienteRepositorio = new ClienteRepositorioDAO(connection);
            IMaterialRepositorio materialRepositorio = new MaterialRepositorioDAO(connection);
            IPedidoRepositorio pedidoRepositorio = new PedidoRepositorioDAO(connection);
            IPedidoItemRepositorio pedidoItemRepositorio = new PedidoItemRepositorioDAO(connection);
            IProdutoRepositorio produtoRepositorio = new ProdutoRepositorioDAO(connection);
            IProdutoMaterialRepositorio produtoMaterialRepositorio = new ProdutoMaterialRepositorioDAO(connection);

            List<Cidade> cidadeList = cidadeRepositorio.toList();
            List<Cliente> clienteList = clienteRepositorio.toList();
            List<Material> materialList = materialRepositorio.toList();
            List<Pedido> pedidoList = pedidoRepositorio.toList();
            List<PedidoItem> pedidoItemList = pedidoItemRepositorio.toList();
            List<Produto> produtoList = produtoRepositorio.toList();
            List<ProdutoMaterial> produtoMaterialList = produtoMaterialRepositorio.toList();

            try {
                csv.exportarCidade("cidadeBackup.csv", cidadeList);
                csv.exportarCliente("clienteBackup.csv", clienteList);
                csv.exportarMaterial("materialBackup.csv", materialList);
                csv.exportarPedido("pedidoBackup.csv", pedidoList);
                csv.exportarPedidoItem("pedidoItemBackup.csv", pedidoItemList);
                csv.exportarProduto("produtoBackup.csv", produtoList);
                csv.exportarProdutoMaterial("produtoMaterialBackup.csv", produtoMaterialList);
            } catch (IOException ex) {
                System.err.println("Erro ao exportar");
            }
        } catch (SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }
}
