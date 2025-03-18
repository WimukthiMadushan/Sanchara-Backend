package com.organiserdashboard.organiserdashboardservice;

import org.springframework.boot.SpringApplication;

public class TestOrganiserDashboardServiceApplication {

    public static void main(String[] args) {
        SpringApplication.from(OrganiserDashboardServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
