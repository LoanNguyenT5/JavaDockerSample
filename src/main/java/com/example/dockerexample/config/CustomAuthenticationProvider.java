package com.example.dockerexample.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import com.example.dockerexample.entity.UserAdmin;
import com.example.dockerexample.repository.UserAdminRepository;

@Component("authenticationProvider")
public class CustomAuthenticationProvider extends DaoAuthenticationProvider {

    @Autowired
    UserAdminRepository userAdminRepository;

    @Autowired
    @Override
    public void setUserDetailsService(UserDetailsService userDetailsService) {
        super.setUserDetailsService(userDetailsService);
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // TODO Auto-generated method stub
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        UserAdmin user = userAdminRepository.findByUserId(name);
        if (user != null) {
            if (password.equals(user.getPassword())) {
                return new UsernamePasswordAuthenticationToken(name, password,
                        AuthorityUtils.createAuthorityList("ROLE_ADMIN"));
            } else {
                throw new DisabledException("Password is not corect!");
            }

        } else {
            throw new DisabledException("Login fail");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}
