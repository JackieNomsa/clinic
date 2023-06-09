package com.example.slotsBooking.controller;

import com.example.slotsBooking.model.Booking;
import com.example.slotsBooking.model.SlotDetails;
import com.example.slotsBooking.service.ClinicBookingServiceImp;
import com.example.slotsBooking.service.DetailsServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clinic")
public class ClinicController {
    private final ClinicBookingServiceImp clinicBookingServiceImp;
    private final DetailsServiceImp detailsServiceImp;
    public ClinicController(ClinicBookingServiceImp clinicBookingServiceImp, DetailsServiceImp detailsServiceImp){
        this.clinicBookingServiceImp = clinicBookingServiceImp;
        this.detailsServiceImp = detailsServiceImp;
    }
    @PostMapping("/create")
    public ResponseEntity<?> addPatient(@RequestBody Booking patient) {
        Booking booking = this.clinicBookingServiceImp.createBooking(patient);
        SlotDetails[] availableSlots = detailsServiceImp.getAvailableSlots("clinic");
        if(booking != null){
            return ResponseEntity.status(HttpStatus.OK).body(availableSlots);
        }return ResponseEntity.status(HttpStatus.CONFLICT).build();

    }

    @GetMapping("/getById/{id}")
    @ResponseBody
    public ResponseEntity<?> getPatient(@PathVariable String id){
        Booking booking = this.clinicBookingServiceImp.getBookingById(id);
        if(booking != null) return ResponseEntity.ok().body(booking);
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/getAll")
    @ResponseBody
    public ResponseEntity<?> getAllBookings(){
        List<Booking> bookings = this.clinicBookingServiceImp.fetchBookingList();
        if(bookings != null) return ResponseEntity.ok().body(bookings);
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/update")
    public ResponseEntity<?> updatePatient(@RequestBody String patientId,String bookingReference){
        Booking booking = this.clinicBookingServiceImp.updateBooking(patientId,bookingReference);
        if(booking != null) return ResponseEntity.ok().body(booking);
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePatient(@RequestBody Booking patient,@PathVariable String bookingReference){
        Booking booking = this.clinicBookingServiceImp.deleteBookingById(patient);
        if(booking != null) return ResponseEntity.ok().build();
        return ResponseEntity.notFound().build();
    }
}
