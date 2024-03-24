package org.assignment.eventmanagement;

import org.assignment.eventmanagement.service.DataIngestionService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EventManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(EventManagementApplication.class, args);
    }
//    @Bean
//    public CommandLineRunner run(DataIngestionService dataIngestionService) {
//        return args -> {
//
//            dataIngestionService.ingestDataFromCSV();
//        };
    }
//}
