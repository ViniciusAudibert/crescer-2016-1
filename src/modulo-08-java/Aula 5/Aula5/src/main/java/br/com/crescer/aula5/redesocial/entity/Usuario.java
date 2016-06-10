package br.com.crescer.aula5.redesocial.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll",
            query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByName",
            query = "SELECT u FROM Usuario u WHERE UPPER() LIKE UPPER()")
})
@Table(name = "USUARIO")
public class Usuario implements Serializable {

    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_USUARIO")
    @SequenceGenerator(name = "SEQ_USUARIO", sequenceName = "SEQ_USUARIO", allocationSize = 1)
    @Column(name = "ID_USUARIO")
    private Long idUsuario;

    @Basic(optional = false)
    @Column(name = "NM_USUARIO")
    private String nmUsuario;

    @OneToMany(mappedBy = "usuario")
    private List<Amigo> amigos;
    
    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setNmUsuario(String nmUsuario) {
        this.nmUsuario = nmUsuario;
    }

    public void setAmigos(List<Amigo> amigos) {
        this.amigos = amigos;
    }

    public List<Amigo> getAmigos() {
        return amigos;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public String getNmUsuario() {
        return nmUsuario;
    }
}
