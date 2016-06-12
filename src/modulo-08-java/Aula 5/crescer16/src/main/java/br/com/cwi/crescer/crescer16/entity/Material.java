package br.com.cwi.crescer.crescer16.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Vinicius
 */
@Entity
@Table(name = "MATERIAL")
public class Material implements Serializable {

    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_MATERIAL")
    @SequenceGenerator(name = "SEQ_MATERIAL", sequenceName = "SEQ_MATERIAL")
    @Column(name = "IDMATERIAL")
    private int idMaterial;

    @Basic(optional = false)
    @Column(name = "DESCRICAO")
    private String descricao;

    @Basic(optional = false)
    @Column(name = "PESOLIQUIDO")
    private BigDecimal pesoLiquido;

    @Basic(optional = false)
    @Column(name = "PRECOCUSTO")
    private BigDecimal precoCusto;

    public int getIdMaterial() {
        return idMaterial;
    }

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getPesoLiquido() {
        return pesoLiquido;
    }

    public BigDecimal getPrecoCusto() {
        return precoCusto;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPesoLiquido(BigDecimal pesoLiquido) {
        this.pesoLiquido = pesoLiquido;
    }

    public void setPrecoCusto(BigDecimal precoCusto) {
        this.precoCusto = precoCusto;
    }
    
    
}
