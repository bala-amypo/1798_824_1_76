package com.example.demo.security;

import com.example.demo.model.User;
import org.springframework.security.core.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public class UserPrincipal implements UserDetails {

    private final String username;
    private final String password;
    private final List<GrantedAuthority> authorities;

    private UserPrincipal(String username,
                          String password,
                          List<GrantedAuthority> authorities) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    public static UserPrincipal create(User user) {
        return new UserPrincipal(
                user.getEmail(),
                user.getPassword(),
                List.of(new SimpleGrantedAuthority(user.getRole()))
        );
    }

    @Override public String getUsername() { return username; }
    @Override public String getPassword() { return password; }
    @Override public List<GrantedAuthority> getAuthorities() { return authorities; }

    @Override public boolean isAccountNonExpired() { return true; }
    @Override public boolean isAccountNonLocked() { return true; }
    @Override public boolean isCredentialsNonExpired() { return true; }
    @Override public boolean isEnabled() { return true; }
}
