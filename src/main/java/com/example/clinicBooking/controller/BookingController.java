package com.example.clinicBooking.controller;

import com.example.clinicBooking.dto.BookingDTO;
import com.example.clinicBooking.model.Booking;
import com.example.clinicBooking.repository.BookingRepository;
import com.example.clinicBooking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AutoConfiguration
@RequestMapping("/clinic")
public class BookingController {
    @Autowired
    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService){
        this.bookingService = bookingService;
    }
    @RequestMapping(value = "/create",
            method = RequestMethod.POST, produces = "application.json")
    @ResponseBody
    public ResponseEntity<?> addPatient(@RequestBody Booking patient) {
        this.bookingService.addPatient(patient);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
