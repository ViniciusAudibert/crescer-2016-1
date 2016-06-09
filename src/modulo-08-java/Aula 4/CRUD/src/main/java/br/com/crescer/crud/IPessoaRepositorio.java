package br.com.crescer.crud;

import java.util.List;

public interface IPessoaRepositorio {
    
    void insert(Pessoa pessoa);
    void update(Pessoa pessoa);
    void delete(int id);
    List<Pessoa> listAll();
    List<Pessoa> findNome(String nome);
}
