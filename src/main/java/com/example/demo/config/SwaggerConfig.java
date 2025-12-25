package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI userManagementAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("User Management API")
                        .description("REST API for user registration, login and management")
                        .version("1.0"));
    }
}