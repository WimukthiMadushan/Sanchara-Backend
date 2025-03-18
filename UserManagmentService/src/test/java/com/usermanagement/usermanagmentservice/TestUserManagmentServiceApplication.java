package com.usermanagement.usermanagmentservice;

import org.springframework.boot.SpringApplication;

public class TestUserManagmentServiceApplication {

    public static void main(String[] args) {
        SpringApplication.from(UserManagmentServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
