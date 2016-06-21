/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.repositorios;

import br.com.crescer.entity.Usuario;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author vinicius.audibert
 */
public interface UsuarioRepositorio extends CrudRepository<Usuario, Long> {

    Usuario findOneByUsername(String username);
}
 