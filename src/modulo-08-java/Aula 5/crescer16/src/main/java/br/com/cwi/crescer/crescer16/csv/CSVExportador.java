package br.com.cwi.crescer.crescer16.csv;

import br.com.cwi.crescer.crescer16.entity.Cidade;
import br.com.cwi.crescer.crescer16.entity.Cliente;
import br.com.cwi.crescer.crescer16.entity.Material;
import br.com.cwi.crescer.crescer16.entity.Pedido;
import br.com.cwi.crescer.crescer16.entity.PedidoItem;
import br.com.cwi.crescer.crescer16.entity.Produto;
import br.com.cwi.crescer.crescer16.entity.ProdutoMaterial;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Vinicius
 */
public class CSVExportador {

    public void exportarCidade(String path, List<Cidade> cidades) throws IOException {
        File file = new File(path);
        file.createNewFile();

        try (FileWriter writer = new FileWriter(file)) {
            for (Cidade cidade : cidades) {
                writer.append(cidade.getIdCidade() + ";");
                writer.append(cidade.getNome() + ";");
                writer.append(cidade.getUf() + "\n");
            }
            writer.flush();
        }
    }

    public void exportarCliente(String path, List<Cliente> clientes) throws IOException {
        File file = new File(path);
        file.createNewFile();

        try (FileWriter writer = new FileWriter(file)) {
            for (Cliente cliente : clientes) {
                writer.append(cliente.getIdCliente() + ";");
                writer.append(cliente.getNome() + ";");
                writer.append(cliente.getRazaoSocial() + ";");
                writer.append(cliente.getEndereco() + ";");
                writer.append(cliente.getBairro() + ";");
                writer.append(cliente.getIdCidade() + ";");
                writer.append(cliente.getCep() + ";");
                writer.append(cliente.getSituacao() + "\n");
            }
            writer.flush();
        }
    }

    public void exportarMaterial(String path, List<Material> materiais) throws IOException {
        File file = new File(path);
        file.createNewFile();

        try (FileWriter writer = new FileWriter(file)) {
            for (Material material : materiais) {
                writer.append(material.getIdMaterial() + ";");
                writer.append(material.getDescricao() + ";");
                writer.append(material.getPesoLiquido() + ";");
                writer.append(material.getPrecoCusto() + "\n");
            }
            writer.flush();
        }
    }

    public void exportarPedido(String path, List<Pedido> pedidos) throws IOException {
        File file = new File(path);
        file.createNewFile();

        try (FileWriter writer = new FileWriter(file)) {
            for (Pedido pedido : pedidos) {
                writer.append(pedido.getIdPedido() + ";");
                writer.append(pedido.getIdCliente() + ";");
                writer.append(pedido.getDataPedido() + ";");
                writer.append(pedido.getDataEntrega() + ";");
                writer.append(pedido.getValorPedido() + ";");
                writer.append(pedido.getSituacao() + "\n");
            }
            writer.flush();
        }
    }

    public void exportarProduto(String path, List<Produto> produtos) throws IOException {
        File file = new File(path);
        file.createNewFile();

        try (FileWriter writer = new FileWriter(file)) {
            for (Produto produto : produtos) {
                writer.append(produto.getIdProduto() + ";");
                writer.append(produto.getNome() + ";");
                writer.append(produto.getDataCadastro() + ";");
                writer.append(produto.getPrecoCusto() + ";");
                writer.append(produto.getPrecoVenda() + ";");
                writer.append(produto.getSituacao() + "\n");
            }
            writer.flush();
        }
    }
    public void exportarProdutoMaterial(String path, List<ProdutoMaterial> produtosMateriais) throws IOException {
        File file = new File(path);
        file.createNewFile();

        try (FileWriter writer = new FileWriter(file)) {
            for (ProdutoMaterial produtoMaterial : produtosMateriais) {
                writer.append(produtoMaterial.getIdProdutoMaterial()+ ";");
                writer.append(produtoMaterial.getIdProduto()+ ";");
                writer.append(produtoMaterial.getIdMaterial()+ ";");
                writer.append(produtoMaterial.getQuantidade()+ "\n");
            }
            writer.flush();
        }
    }
    public void exportarPedidoItem(String path, List<PedidoItem> pedidosItens) throws IOException {
        File file = new File(path);
        file.createNewFile();

        try (FileWriter writer = new FileWriter(file)) {
            for (PedidoItem pedidoItem : pedidosItens) {
                writer.append(pedidoItem.getIdPedidoItem()+ ";");
                writer.append(pedidoItem.getPedido()+ ";");
                writer.append(pedidoItem.getQuantidade()+ ";");
                writer.append(pedidoItem.getPrecoUnitario()+ ";");
                writer.append(pedidoItem.getSituacao()+ ";");
                writer.append(pedidoItem.getIdProduto()+ "\n");
            }
            writer.flush();
        }
    }
}
