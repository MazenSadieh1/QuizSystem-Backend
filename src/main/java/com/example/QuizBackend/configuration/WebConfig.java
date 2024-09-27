package com.example.QuizBackend.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("http://localhost:4200", "http://localhost:**", "*") // Hier die Erlaubten Origins hinzufügen
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTION") // Erlaubte HTTP-Methoden
                .allowedHeaders("*"); // Erlaubte Header
    }
}
