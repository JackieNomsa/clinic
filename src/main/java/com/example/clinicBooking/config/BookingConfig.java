package com.example.clinicBooking.config;

import com.example.clinicBooking.model.Booking;
import com.example.clinicBooking.repository.BookingRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackageClasses = Booking.class)
@EnableJpaRepositories(basePackageClasses = BookingRepository.class)
public class BookingConfig{}
