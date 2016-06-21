package br.com.crescer.security;

import br.com.crescer.entity.Usuario;
import br.com.crescer.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author Carlos H. Nonnemacher
 */
@Service
public class CrescerUserDetailsService implements UserDetailsService {

    private static final String CRESCER = "crescer";
    
    @Autowired
    UsuarioService service;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username.isEmpty()) {
            throw new UsernameNotFoundException(String.format("User with username=%s was not found", username));
        }
        Usuario user = service.findByUsername(username);
//        return new User(username, new BCryptPasswordEncoder().encode(CRESCER), Roles.valuesToList());
        return new User(user.getUsername(), user.getSenha(), Roles.valuesToList());
    }

}
