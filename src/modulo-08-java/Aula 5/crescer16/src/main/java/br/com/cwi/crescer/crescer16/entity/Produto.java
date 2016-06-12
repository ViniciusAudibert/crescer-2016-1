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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Vinicius
 */
@Entity
@Table(name = "PRODUTO")
public class Produto implements Serializable {

    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_PRODUTO")
    @SequenceGenerator(name = "SEQ_PRODUTO", sequenceName = "SEQ_PRODUTO")
    @Column(name = "IDPRODUTO")
    private int idProduto;

    @Basic(optional = false)
    @Column(name = "NOME")
    private String nome;

    @Temporal(TemporalType.DATE)
    @Basic(optional = false)
    @Column(name = "DATACADASTRO")
    private Date dataCadastro;

    @Basic(optional = false)
    @Column(name = "PRECOCUSTO")
    private BigDecimal precoCusto;

    @Column(name = "PRECOVENDA")
    private BigDecimal precoVenda;

    @Basic(optional = false)
    @Column(name = "SITUACAO")
    private char situacao;

    public int getIdProduto() {
        return idProduto;
    }

    public String getNome() {
        return nome;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public BigDecimal getPrecoCusto() {
        return precoCusto;
    }

    public BigDecimal getPrecoVenda() {
        return precoVenda;
    }

    public char getSituacao() {
        return situacao;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public void setPrecoCusto(BigDecimal precoCusto) {
        this.precoCusto = precoCusto;
    }

    public void setPrecoVenda(BigDecimal precoVenda) {
        this.precoVenda = precoVenda;
    }

    public void setSituacao(char situacao) {
        this.situacao = situacao;
    }
    
    
}
