package br.com.cwi.crescer.crescer16.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Vinicius
 */
@Entity
@Table(name = "PEDIDO")
public class Pedido implements Serializable {

    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_PEDIDO")
    @SequenceGenerator(name = "SEQ_PEDIDO", sequenceName = "SEQ_PEDIDO")
    @Column(name = "IDPEDIDO")
    private int idPedido;

    @ManyToOne
    @JoinColumn(name = "IDCLIENTE", referencedColumnName = "IDCLIENTE")
    private Cliente cliente;
    
    @Basic(optional = false)
    @Column(name = "IDCLIENTE")
    private int idCliente;

    @Temporal(TemporalType.DATE)
    @Basic(optional = false)
    @Column(name = "DATAPEDIDO")
    private Date dataPedido;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATAENTREGA")
    private Date dataEntrega;

    @Basic(optional = false)
    @Column(name = "VALORPEDIDO")
    private BigDecimal valorPedido;

    @Basic(optional = false)
    @Column(name = "SITUACAO", columnDefinition = "default 'A'")
    private char situacao;

    public int getIdPedido() {
        return idPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public BigDecimal getValorPedido() {
        return valorPedido;
    }

    public char getSituacao() {
        return situacao;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public void setValorPedido(BigDecimal valorPedido) {
        this.valorPedido = valorPedido;
    }

    public void setSituacao(char situacao) {
        this.situacao = situacao;
    }
    
    
}
