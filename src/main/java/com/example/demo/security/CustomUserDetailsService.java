package com.example.demo.security;

import org.springframework.security.core.userdetails.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class CustomUserDetailsService implements UserDetailsService {

    private final Map<String, UserPrincipal> users = new HashMap<>();
    private final AtomicLong idGen = new AtomicLong(1);

    public UserPrincipal register(String email, String password, String role) {
        UserPrincipal user = new UserPrincipal(
                idGen.getAndIncrement(),
                email,
                password,
                role
        );
        users.put(email, user);
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        UserPrincipal user = users.get(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }
}
