package com.example.clinicBooking.config;

import com.example.clinicBooking.repository.BookingRepository;
import com.example.clinicBooking.service.BookingServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class BookingServiceConfig {
    @Autowired
    public BookingRepository bookingRepository;

}
