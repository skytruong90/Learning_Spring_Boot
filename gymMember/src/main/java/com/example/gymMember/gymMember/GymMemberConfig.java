package com.example.gymMember.gymMember;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class GymMemberConfig {
    @Bean
    CommandLineRunner commandLineRunner(
            GymMemberRepository repository){
        return args -> {
            GymMember mariam = new GymMember(

                    "Mariam",
                    "mariam.jamal@gmail.com",
                    LocalDate.of(2000, JANUARY, 05),
                    200.0
            );

            GymMember alex = new GymMember(

                    "Alex",
                    "alex@gmail.com",
                    LocalDate.of(2000, JANUARY, 05),
                    200.0
            );

            repository.saveAll(
                    List.of(mariam, alex)
            );
        };
    }
}
