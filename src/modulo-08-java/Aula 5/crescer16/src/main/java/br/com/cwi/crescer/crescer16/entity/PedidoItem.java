package br.com.cwi.crescer.crescer16.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Vinicius
 */
@Entity
@Table(name = "PEDIDOITEM")
public class PedidoItem implements Serializable {

    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_PEDIDOITEM")
    @SequenceGenerator(name = "SEQ_PEDIDOITEM", sequenceName = "SEQ_PEDIDOITEM")
    @Column(name = "IDPEDIDOITEM")
    private int idPedidoItem;

    @ManyToOne
    @JoinColumn(name = "IDPEDIDO", referencedColumnName = "IDPEDIDO")
    private Pedido pedido;

    @Basic(optional = false)
    @Column(name = "IDPEDIDO")
    private int idPedido;
    
    @Basic(optional = false)
    @Column(name = "QUANTIDADE")
    private int quantidade;

    @Basic(optional = false)
    @Column(name = "PRECOUNITARIO")
    private BigDecimal precoUnitario;

    @Basic(optional = false)
    @Column(name = "SITUACAO", columnDefinition = "default 'A'")
    private char situacao;

    @ManyToOne
    @JoinColumn(name = "IDPRODUTO", referencedColumnName = "IDPRODUTO")
    private Produto produto;
    
    @Column(name = "IDPRODUTO")
    private int idProduto;

    public int getIdPedidoItem() {
        return idPedidoItem;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public char getSituacao() {
        return situacao;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setIdPedidoItem(int idPedidoItem) {
        this.idPedidoItem = idPedidoItem;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public void setSituacao(char situacao) {
        this.situacao = situacao;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

}
