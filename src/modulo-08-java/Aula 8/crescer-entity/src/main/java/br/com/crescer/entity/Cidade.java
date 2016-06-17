package br.com.crescer.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author vinicius.audibert
 */
@Entity
@Table(name = "CIDADE")
@NamedQueries({
    @NamedQuery(name = "Cidade.findAll", query = "SELECT c FROM Cidade c"),
    @NamedQuery(name = "Cidade.findByIdcidade", query = "SELECT c FROM Cidade c WHERE c.idcidade = :idcidade"),
    @NamedQuery(name = "Cidade.findByNome", query = "SELECT c FROM Cidade c WHERE c.nome = :nome"),
    @NamedQuery(name = "Cidade.findByUf", query = "SELECT c FROM Cidade c WHERE c.uf = :uf")})
public class Cidade implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name = "SEQ_CIDADE", sequenceName = "SEQ_CIDADE", allocationSize = 1)
    @Column(name = "IDCIDADE")
    private long idcidade;
    @Basic(optional = false)
    @Column(name = "NOME")
    private String nome;
    @Basic(optional = false)
    @Column(name = "UF")
    private String uf;

    public Cidade() {
    }

    public Cidade(long idcidade) {
        this.idcidade = idcidade;
    }

    public Cidade(long idcidade, String nome, String uf) {
        this.idcidade = idcidade;
        this.nome = nome;
        this.uf = uf;
    }

    public long getIdcidade() {
        return idcidade;
    }

    public void setIdcidade(long idcidade) {
        this.idcidade = idcidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public String toString() {
        return "br.com.crescer.entity.Cidade[ idcidade=" + idcidade + " ]";
    }
    
}
