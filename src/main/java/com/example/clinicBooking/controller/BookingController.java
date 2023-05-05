package com.example.clinicBooking.controller;

import com.example.clinicBooking.model.Booking;
import com.example.clinicBooking.service.BookingServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/clinic")
public class BookingController {
    @Autowired
    private final BookingServiceImp bookingServiceImp;

    @Autowired
    public BookingController(BookingServiceImp bookingServiceImp){
        this.bookingServiceImp = bookingServiceImp;
    }
    @PostMapping("/create")
    public ResponseEntity<?> addPatient(@RequestBody Booking patient) {
        this.bookingServiceImp.createBooking(patient);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/getById/{id}")
    @ResponseBody
    public ResponseEntity getPatient(@PathVariable String id){
        Booking booking = this.bookingServiceImp.getBookingById(id);
        if(booking != null) return ResponseEntity.ok().body(booking);
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/update")
    public ResponseEntity updatePatient(@RequestBody Booking patient){
        Booking booking = this.bookingServiceImp.updateBooking(patient);
        if(booking != null) return ResponseEntity.ok().body(booking);
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity deletePatient(@PathVariable String id){
        Booking booking = this.bookingServiceImp.deleteBookingById(id);
        if(booking != null) return ResponseEntity.ok().build();
        return ResponseEntity.notFound().build();
    }
}
