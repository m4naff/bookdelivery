package com.example;

import org.springframework.boot.SpringApplication;

public class TestBookdeliveryApplication {

    public static void main(String[] args) {
        SpringApplication.from(BookdeliveryApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
