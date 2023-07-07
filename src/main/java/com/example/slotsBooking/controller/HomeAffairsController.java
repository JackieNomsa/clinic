package com.example.slotsBooking.controller;

import com.example.slotsBooking.model.Booking;
import com.example.slotsBooking.model.BookingType;
import com.example.slotsBooking.model.SlotDetails;
import com.example.slotsBooking.service.DetailsServiceImp;
import com.example.slotsBooking.service.HomeAffairsServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/homeaffairs")
public class HomeAffairsController {
    private final HomeAffairsServiceImpl homeAffairsServiceImpl;
    private final DetailsServiceImp detailsServiceImp;
    BookingType type = BookingType.HOMEAFFAIRS;
    public HomeAffairsController(HomeAffairsServiceImpl homeAffairsServiceImpl, DetailsServiceImp detailsServiceImp) {
        this.homeAffairsServiceImpl = homeAffairsServiceImpl;
        this.detailsServiceImp = detailsServiceImp;
    }

    @PostMapping("/create")
    public ResponseEntity<?> addClient(@RequestBody Booking client) {
        Booking booking = this.homeAffairsServiceImpl.createBooking(client);
        SlotDetails[] availableSlots = detailsServiceImp.getAvailableSlots("homeaffairs");
        if(booking != null){
            return ResponseEntity.status(HttpStatus.OK).body(availableSlots);
        }return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }


    @GetMapping("/getById/{id}")
    @ResponseBody
    public ResponseEntity<?> getPatient(@PathVariable String id){
        Booking booking = this.homeAffairsServiceImpl.getBookingById(id);
        if(booking != null) return ResponseEntity.ok().body(booking);
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/getAll")
    @ResponseBody
    public ResponseEntity<?> getAllBookings(){
        List<Booking> bookings = this.homeAffairsServiceImpl.fetchBookingList();
        if(bookings != null) return ResponseEntity.ok().body(bookings);
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateClient(@RequestBody String clientId,String bookingReference){
        Booking booking = this.homeAffairsServiceImpl.updateBooking(clientId,bookingReference);
        if(booking != null) return ResponseEntity.ok().body(booking);
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable String id){
        Booking booking = this.homeAffairsServiceImpl.deleteBookingById(id);
        if(booking != null) return ResponseEntity.ok().build();
        return ResponseEntity.notFound().build();
    }
}
