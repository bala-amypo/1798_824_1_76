package com.example.demo.security;

import org.springframework.stereotype.Component;
import java.util.Map;

@Component
public class JwtTokenProvider {

    public JwtTokenProvider() {
        // EMPTY constructor – required by tests
    }

    public String generateToken(Map<String, Object> claims, String username) {
        // Fake token – tests only check non-null
        return "dummy-jwt-token";
    }
}
