package com.example.demo.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class CustomUserDetailsService implements UserDetailsService {

    private final Map<String, UserPrincipal> store = new HashMap<>();
    private final AtomicLong idGen = new AtomicLong(1);

    public UserPrincipal register(String email, String password, String role) {
        UserPrincipal p = new UserPrincipal(
                idGen.getAndIncrement(),
                email,
                password,
                role
        );
        store.put(email, p);
        return p;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        UserPrincipal p = store.get(username);
        if (p == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return p;
    }
}
