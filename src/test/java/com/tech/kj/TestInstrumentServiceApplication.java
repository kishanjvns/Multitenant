package com.tech.kj;

import org.springframework.boot.SpringApplication;

public class TestInstrumentServiceApplication {
    public static void main(String[] args) {
        SpringApplication.from(MultitenantApplication::main)
                .with(TestContainerConfig.class)
                .run(args);
    }
}
