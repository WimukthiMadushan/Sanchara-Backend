package com.eventmanagement.eventmanagmentsystem;

import org.springframework.boot.SpringApplication;

public class TestEventManagmentSystemApplication {

    public static void main(String[] args) {
        SpringApplication.from(EventManagmentSystemApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
