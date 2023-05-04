package com.example.clinicBooking.controller;

import com.example.clinicBooking.model.Booking;
import com.example.clinicBooking.service.BookingServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clinic")
public class BookingController {
    @Autowired
    private final BookingServiceImp bookingServiceImp;

    @Autowired
    public BookingController(BookingServiceImp bookingServiceImp){
        this.bookingServiceImp = bookingServiceImp;
    }
    @RequestMapping(value = "/create",
            method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> addPatient(@RequestBody Booking patient) {
        this.bookingServiceImp.createBooking(patient);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
