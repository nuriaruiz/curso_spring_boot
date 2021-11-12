package com.example.cursojava.configuration;

import com.example.cursojava.entity.Customer;
import com.example.cursojava.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadTables {

    private static final Logger log = LoggerFactory.getLogger(LoadTables.class);
    @Bean
    CommandLineRunner initDatabase(CustomerRepository customerRepository){
        return args -> {
            log.info("Loading: " + customerRepository.save(new Customer("Customer", "Uno")));
            log.info("Loading: " + customerRepository.save(new Customer("Customer", "Dos")));
            log.info("Loading: " + customerRepository.save(new Customer("Nuria", "Tres")));
            log.info("Search by name: " + customerRepository.findByName("Nuria"));
        };
    }
}
