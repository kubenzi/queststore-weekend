package com.codecool.fusy_qs;

import com.codecool.fusy_qs.entity.*;
import com.codecool.fusy_qs.repository.*;
import com.codecool.fusy_qs.repository.RequestDetailsReposiotry;
import com.codecool.fusy_qs.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FusyQsApplication {

    public static void main(String[] args) {
        SpringApplication.run(FusyQsApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner() {
        return (args) -> {





        };

    }
}
