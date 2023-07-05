package com.example.clinicBooking.controller;

import com.example.clinicBooking.model.Booking;
import com.example.clinicBooking.model.SlotDetails;
import com.example.clinicBooking.service.BookingServiceImp;
import com.example.clinicBooking.service.DetailsServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home-affairs")
public class HomeAffairsController {
    @Autowired
    private final BookingServiceImp bookingServiceImp;
    @Autowired
    private final DetailsServiceImp detailsServiceImp;

    public HomeAffairsController(BookingServiceImp bookingServiceImp, DetailsServiceImp detailsServiceImp) {
        this.bookingServiceImp = bookingServiceImp;
        this.detailsServiceImp = detailsServiceImp;
    }

    @PostMapping("/create")
    public ResponseEntity<?> addClient(@RequestBody Booking client) {
        Booking booking = this.bookingServiceImp.createBooking(client);
        SlotDetails[] availableSlots = detailsServiceImp.getAvailableSlots();
        if(booking != null){
            return ResponseEntity.status(HttpStatus.OK).body(availableSlots);

        }return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }


    @GetMapping("/getById/{id}")
    @ResponseBody
    public ResponseEntity<?> getPatient(@PathVariable String id){
        Booking booking = this.bookingServiceImp.getBookingById(id);
        if(booking != null) return ResponseEntity.ok().body(booking);
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/getAll")
    @ResponseBody
    public ResponseEntity<?> getAllBookings(){
        List<Booking> bookings = this.bookingServiceImp.fetchBookingList();
        if(bookings != null) return ResponseEntity.ok().body(bookings);
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateClient(@RequestBody String clientId,String bookingReference){
        Booking booking = this.bookingServiceImp.updateBooking(clientId,bookingReference);
        if(booking != null) return ResponseEntity.ok().body(booking);
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable String id){
        Booking booking = this.bookingServiceImp.deleteBookingById(id);
        if(booking != null) return ResponseEntity.ok().build();
        return ResponseEntity.notFound().build();
    }
}
