package com.usermanagement.usermanagmentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class UserManagmentServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserManagmentServiceApplication.class, args);
    }
}
