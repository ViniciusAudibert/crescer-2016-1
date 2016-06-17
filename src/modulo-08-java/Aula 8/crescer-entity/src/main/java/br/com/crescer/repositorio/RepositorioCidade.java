package br.com.crescer.repositorio;

import br.com.crescer.entity.Cidade;
import br.com.crescer.irepositorio.IRepositorioCidade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author vinicius.audibert
 */
public class RepositorioCidade implements IRepositorioCidade{
    
    EntityManager entity = Persistence.createEntityManagerFactory("crescerPU").createEntityManager();
    
    @Override
    public long adicionar(Cidade cidade) {
        entity.persist(cidade);
        return this.buscar(cidade).getIdcidade();
    }

    @Override
    public long remover(Cidade cidade) {
        entity.remove(cidade);
        return this.buscar(cidade).getIdcidade();
    }

    @Override
    public long atualizar(Cidade cidade) {
        entity.merge(cidade);
        return this.buscar(cidade).getIdcidade();
    }

    @Override
    public List<Cidade> toList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cidade buscar(Cidade cidade) {
        return entity.find(Cidade.class, cidade);
    }
    
}
