package br.com.cwi.crescer.crescer16.entity;

import java.io.Serializable;
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
@Table(name = "PRODUTOMATERIAL")
public class ProdutoMaterial implements Serializable {

    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_PRODUTOMATERIAL")
    @SequenceGenerator(name = "SEQ_PRODUTOMATERIAL", sequenceName = "SEQ_PRODUTOMATERIAL")
    @Column(name = "IDPRODUTOMATERIAL")
    private int idProdutoMaterial;

    @ManyToOne
    @JoinColumn(name = "IDPRODUTO", referencedColumnName = "IDPRODUTO")
    private Produto produto;

    @Basic(optional = false)
    @Column(name = "IDPRODUTO")
    private int idProduto;

    @ManyToOne
    @JoinColumn(name = "IDMATERIAL", referencedColumnName = "IDMATERIAL")
    private Material material;

    @Basic(optional = false)
    @Column(name = "IDMATERIAL")
    private int idMaterial;
    
    @Column(name = "QUANTIDADE")
    private int quantidade;

    public int getIdProdutoMaterial() {
        return idProdutoMaterial;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public int getIdMaterial() {
        return idMaterial;
    }

    public Material getMaterial() {
        return material;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setIdProdutoMaterial(int idProdutoMaterial) {
        this.idProdutoMaterial = idProdutoMaterial;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

}
