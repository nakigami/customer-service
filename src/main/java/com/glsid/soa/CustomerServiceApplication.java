package com.glsid.soa;

import com.glsid.soa.entities.Customer;
import com.glsid.soa.respositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerRepository customerRepository) {
        return args -> {
            customerRepository.save(new Customer(null, "Anas Riani", "anas.devriani@gmail.com"));
            customerRepository.save(new Customer(null, "Yassine Riani", "yassine.devriani@gmail.com"));
            customerRepository.findAll().forEach(c -> {
                System.out.println("Name : " + c.getName() + " - Email : " + c.getEmail());
            });
        };
    }
}
