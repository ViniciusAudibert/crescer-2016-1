package br.com.cwi.crescer.crescer16.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Vinicius
 */
@Entity
@Table(name = "CIDADE")
public class Cidade implements Serializable {

    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_CIDADE")
    @SequenceGenerator(name = "SEQ_CIDADE", sequenceName = "SEQ_CIDADE")
    @Column(name = "IDCIDADE")
    private int idCidade;

    @Basic(optional = false)
    @Column(name = "NOME")
    private String nome;

    @Basic(optional = false)
    @Column(name = "UF")
    private String uf;

    @OneToMany(mappedBy = "cidade", cascade = CascadeType.ALL)
    private List<Cliente> clientes;

    public int getIdCidade() {
        return idCidade;
    }

    public String getNome() {
        return nome;
    }

    public String getUf() {
        return uf;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setIdCidade(int idCidade) {
        this.idCidade = idCidade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

}
