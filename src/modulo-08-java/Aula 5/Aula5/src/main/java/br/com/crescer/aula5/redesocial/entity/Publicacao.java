package br.com.crescer.aula5.redesocial.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll",
            query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Publicacao.findByName",
            query = "SELECT p FROM Publicacao p WHERE UPPER() LIKE UPPER()")
})
@Table(name = "PUBLICACAO")
public class Publicacao implements Serializable {
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_PUBLICACAO")
    @SequenceGenerator(name = "SEQ_PUBLICACAO", sequenceName = "SEQ_PUBLICACAO", allocationSize = 1)
    @Column(name = "ID_USUARIO")
    private Long idPublicacao;

    @Basic(optional = false)
    @Column(name = "PL_DATA")
    private Date data;
    
    @Basic(optional = false)
    @Column(name = "PL_CONTEUDO")
    private String conteudo;
    
    @Basic(optional = false)
    @Column(name = "PL_USUARIO")
    private Usuario usuario;
}
