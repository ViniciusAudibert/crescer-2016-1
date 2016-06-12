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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Vinicius
 */
@Entity
@Table(name = "CLIENTE")
public class Cliente implements Serializable {

    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_CLIENTE")
    @SequenceGenerator(name = "SEQ_CLIENTE", sequenceName = "SEQ_CLIENTE")
    @Column(name = "IDCLIENTE")
    private int idCliente;

    @Basic(optional = false)
    @Column(name = "NOME")
    private String nome;

    @Basic(optional = false)
    @Column(name = "RAZAOSOCIAL")
    private String razaoSocial;
    
    @Column(name = "ENDERECO")
    private String endereco;
    
    @Column(name = "BAIRRO")
    private String bairro;
    
    @ManyToOne
    @JoinColumn(name = "IDCIDADE", referencedColumnName = "IDCIDADE")
    private Cidade cidade;
    
    @Column(name = "IDCIDADE")
    private int idCidade;
    
    @Column(name = "CEP")
    private long cep;
    
    @Basic(optional = false)
    @Column(name = "SITUACAO", columnDefinition = "default 'A'")
    private char situacao;
    
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Pedido> pedidos;

    public int getIdCliente() {
        return idCliente;
    }

    public String getNome() {
        return nome;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setIdCidade(int idCidade) {
        this.idCidade = idCidade;
    }

    public int getIdCidade() {
        return idCidade;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public long getCep() {
        return cep;
    }

    public char getSituacao() {
        return situacao;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public void setCep(long cep) {
        this.cep = cep;
    }

    public void setSituacao(char situacao) {
        this.situacao = situacao;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
    
    
}
