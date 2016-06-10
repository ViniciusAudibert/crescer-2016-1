package br.com.crescer.aula5.run;

import br.com.crescer.aula5.entity.Pessoa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class AppRun {

    static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRESCER16");
    static final EntityManager em = emf.createEntityManager();

    public static void main(String[] args) {
//        System.out.println(em.isOpen());
//        
//        em.getTransaction().begin();
//        
//        Pessoa pessoa = new Pessoa();
//        pessoa.setNmPessoa("asasasasasassasasasasassasasa");
//        
//        em.persist(pessoa);
//        
//        em.getTransaction().commit();

        Query query = em.createNamedQuery("Pessoa.findAll");
        //query.setParameter(":pNMPessoa", "Vinicius");
        
        List<Pessoa> pessoas = query.getResultList();
        pessoas.stream().map(Pessoa::getNmPessoa).forEach(System.out::println);
        
        em.close();
        emf.close();
    }
}
