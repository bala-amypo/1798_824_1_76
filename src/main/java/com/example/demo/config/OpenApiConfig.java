package com.example.demo.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        final String securitySchemeName = "basicAuth";
        
        return new OpenAPI()
                .info(new Info()
                        .title("Conflict of Interest Detection Engine API")
                        .version("1.0")
                        .description("Backend APIs for COI Engine (Basic Password Authentication)")
                )
                // 1. Add the Security Requirement (applies the lock icon to all routes)
                .addSecurityItem(new SecurityRequirement().addList(securitySchemeName))
                // 2. Define the Security Scheme (Username/Password)
                .components(new Components()
                        .addSecuritySchemes(securitySchemeName,
                                new SecurityScheme()
                                        .name(securitySchemeName)
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("basic")
                                        .description("Enter your username and password to access the APIs")
                        )
                )
                .servers(List.of(
                        new Server().url("https://9189.32procr.amypo.ai")
                ));
    }
}