package com.wwh.whblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class WhblogApplication {

    public static void main(String[] args) {
        SpringApplication.run(WhblogApplication.class, args);
    }

}
