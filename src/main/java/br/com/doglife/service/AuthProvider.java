package br.com.doglife.service;

import br.com.doglife.entity.User;
import br.com.doglife.exception.InativeUserException;
import br.com.doglife.exception.LoginException;
import br.com.doglife.exception.LoginNotFoundException;
import org.jasypt.util.password.PasswordEncryptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

@Component
public class AuthProvider implements AuthenticationProvider {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationProvider.class);

    private static final GrantedAuthority ROLE_USER = new SimpleGrantedAuthority("ROLE_USER");

    private static final String ROLE_PREFIX = "ROLE_";

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncryptor passwordEncryptor;

    @Override
    public Authentication authenticate(final Authentication authentication) {
        try {
            String username = extractLogin(authentication);
            String password = passwordEncryptor.encryptPassword(extractPassword(authentication));
            User user = userService.findByUsernameAndPassword(username, password);
            Collection<GrantedAuthority> userAuthorities = new ArrayList<>();

            if(user != null) {
                userAuthorities.add(ROLE_USER);
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password, userAuthorities);
                authenticationToken.setDetails(user);
                return authenticationToken;
            }
        } catch (LoginException e) {
            asAuthenticationException(e);
            throw unknownError();
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

    private String extractPassword(final Authentication authentication) {
        final String password = authentication.getCredentials().toString();
        if (password.trim().isEmpty())
            throw new AuthenticationServiceException("Senha requerida");
        else
            return password;
    }

    private String extractLogin(final Authentication authentication) {
        final String login = authentication.getPrincipal().toString();
        if (login.trim().isEmpty())
            throw new AuthenticationServiceException("Usuário requerido");
        else
            return login;
    }

    private AuthenticationException unknownError() {
        return new AuthenticationServiceException("Não foi possível realizar a autenticação.");
    }

    private AuthenticationException asAuthenticationException(final LoginException exception) {
        if (exception instanceof LoginNotFoundException){
            LOGGER.error("Erro de credencial", exception);
            throw new BadCredentialsException("Login não encontrado");
        }
        else if(exception instanceof InativeUserException) {
            LOGGER.error("Usuário inátivo", exception);
            throw new BadCredentialsException("Usuário inátivo");
        }
        else
            LOGGER.error("Não foi possível concluír o acesso", exception);
        throw unknownError();
    }
}
