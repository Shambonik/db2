package com.example.db2.entities.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    JURY, ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
