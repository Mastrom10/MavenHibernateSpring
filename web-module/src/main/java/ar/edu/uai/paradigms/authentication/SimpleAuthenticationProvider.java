package ar.edu.uai.paradigms.authentication;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Federico on 24/03/2015.
 */
public class SimpleAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) {
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        if (name.equals("admin") && password.equals("admin")) {
            List<GrantedAuthority> grants = new ArrayList();
            grants.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            return new UsernamePasswordAuthenticationToken(name, password, grants);
        } else {
            return null;
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
