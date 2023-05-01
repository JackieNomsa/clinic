package com.example.clinicBooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class ClinicBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClinicBookingApplication.class, args);
	}

}
