package com.ffiaux.config.provider;

import com.ffiaux.config.details.CustomUserDetails;
import com.ffiaux.model.User;
import com.ffiaux.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 * Created by ffiaux on 27/05/2016.
 */
@Service
public class CustomAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {
    @Autowired
    private UserRepository userRepository;

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {

    }

    @Override
    protected UserDetails retrieveUser(String s, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {
        CustomUserDetails customUserDetails = null;

        //String principal = usernamePasswordAuthenticationToken.getPrincipal().toString();
        String credentials = usernamePasswordAuthenticationToken.getPrincipal().toString();

        User user = userRepository.findByUserName(s);
        customUserDetails = new CustomUserDetails(user);

        return customUserDetails;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        CustomUserDetails customUserDetails = null;

        String principal = authentication.getPrincipal().toString();
        String credentials = authentication.getPrincipal().toString();

        User user = userRepository.findByUserName(principal);
        customUserDetails = new CustomUserDetails(user);

        Authentication auth = new UsernamePasswordAuthenticationToken(customUserDetails, customUserDetails.getPassword(), customUserDetails.getAuthorities());

        return auth;
    }
}
