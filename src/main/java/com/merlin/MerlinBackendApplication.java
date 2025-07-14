package com.merlin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MerlinBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(MerlinBackendApplication.class, args);
    }

    @GetMapping
    public String MerlinBackendApplication() {
        return "Merlin Backend Application is running!";
    }
}
