package com.example.clinicBooking;

import com.example.clinicBooking.config.BookingConfig;
import com.example.clinicBooking.repository.BookingRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@Configuration
@AutoConfiguration
public class ClinicBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookingConfig.class, args);
	}

}
