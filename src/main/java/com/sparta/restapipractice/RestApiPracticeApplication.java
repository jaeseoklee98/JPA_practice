package com.sparta.restapipractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class RestApiPracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestApiPracticeApplication.class, args);
    }

}
