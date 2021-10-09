package com.core.sec.security.provider;

import com.core.sec.security.AjaxAuthenticationToken;
import com.core.sec.security.service.CustomUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

public class AjaxAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username = authentication.getName();
        String password = (String) authentication.getCredentials();

        CustomUser customUser = (CustomUser) userDetailsService.loadUserByUsername(username);

        if (!passwordEncoder.matches(password, customUser.getAccount().getPassword())) {
            throw new BadCredentialsException("BadCredentialsException");
        }

        AjaxAuthenticationToken token
                = new AjaxAuthenticationToken(customUser.getAccount(), null, customUser.getAuthorities());

        return token;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return AjaxAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
