package com.example.integratedsj2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Integratedsj2Application {

    public static void main(String[] args) {
        SpringApplication.run(Integratedsj2Application.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("http://localhost:5173", "http://127.0.0.1:5173", "http://ip23sj2.sit.kmutt.ac.th")
                        .allowedMethods("GET", "POST", "PUT", "DELETE");
            }
        };
    }
}
