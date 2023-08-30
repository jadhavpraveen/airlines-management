package com.renaissance.referencedataservice;

import com.renaissance.referencedataservice.model.Airport;
import com.renaissance.referencedataservice.repository.AirportRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class ReferencedataServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReferencedataServiceApplication.class, args);
    }
//
//    @Bean
//    CommandLineRunner runner(AirportRepository repository)  {
//        return args -> {
//            Airport airport = new Airport("MUM", "Mumbai", "INDIA");
//            repository.insert(airport);
//        };
//
//    }

}
