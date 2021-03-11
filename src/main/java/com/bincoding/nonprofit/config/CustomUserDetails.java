package com.bincoding.nonprofit.config;

import com.bincoding.nonprofit.entity.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CustomUserDetails implements org.springframework.security.core.userdetails.UserDetails {

    private String username;
    private String password;
    private String active;
    private List<GrantedAuthority> authorities;


    public CustomUserDetails(UserEntity user) {
        this.username = user.getUsername();

        this.password = user.getPassword();
        if(user.getRoles() != null) {
            this.authorities = Arrays.stream(user.getRoles().split(","))
                    .map(SimpleGrantedAuthority::new)
                    .collect(Collectors.toList());
        }
    }

    public CustomUserDetails(String username) {
        this.username = username;
    }

    public CustomUserDetails() {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
       return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}