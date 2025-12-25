package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI userManagementAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("User Management API")
                        .description("REST API for user registration, login and management")
                        .version("1.0"))
                .servers(List.of(
                        new Server().url("https://9376.pro604cr.amypo.ai/").description("Server")
                ));
    }
}