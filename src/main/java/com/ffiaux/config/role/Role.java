package com.ffiaux.config.role;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by ffiaux on 28/05/2016.
 */
public class Role implements GrantedAuthority {
    String authority;

    public Role() {}

    public Role(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }
}
