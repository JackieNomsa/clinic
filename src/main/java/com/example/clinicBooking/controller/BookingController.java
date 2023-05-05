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

    @RequestMapping(value = "/getById/{id}",
            method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getPatient(@RequestBody String id){
        Booking booking = this.bookingServiceImp.getBookingById(id);
        if(booking != null) ResponseEntity.ok().body(booking);
        return ResponseEntity.notFound().build();
    }

    @RequestMapping(value = "/update",
            method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity updatePatient(@RequestBody Booking patient){
        Booking booking = this.bookingServiceImp.updateBooking(patient,patient.getPatientId());
        if(booking != null) ResponseEntity.ok().body(booking);
        return ResponseEntity.notFound().build();
    }

    @RequestMapping(value = "/delete",
            method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity deletePatient(@RequestBody String id){
        this.bookingServiceImp.deleteBookingById(id);
        return ResponseEntity.ok().build();
    }

}
