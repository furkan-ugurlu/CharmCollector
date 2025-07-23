package com.merlin;

import com.merlin.myBoard.Alien;
import com.merlin.myBoard.MyComputer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MerlinBackendApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MerlinBackendApplication.class, args);

    }
}