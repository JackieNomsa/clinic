package com.example.clinicBooking.config;

import com.example.clinicBooking.model.Booking;
import com.example.clinicBooking.repository.BookingRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan({"com.example"})
@EntityScan(basePackages = "com.example")
@EnableJpaRepositories(basePackages = "com.example")
public class BookingConfig{

}
