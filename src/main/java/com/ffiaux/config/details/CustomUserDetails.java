package com.ffiaux.config.details;

import com.ffiaux.config.role.Role;
import com.ffiaux.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by ffiaux on 28/05/2016.
 */
public class CustomUserDetails implements UserDetails {
    private User user;

    private List<Role> authorities;

    public CustomUserDetails() {}

    public CustomUserDetails(User user) {
        this.user = user;
        this.authorities = new ArrayList<Role>();
        authorities.add(new Role("USER"));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
