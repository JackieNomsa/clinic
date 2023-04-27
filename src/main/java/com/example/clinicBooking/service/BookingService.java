package com.example.clinicBooking.service;

import com.example.clinicBooking.dto.BookingDTO;
import com.example.clinicBooking.model.Booking;
import com.example.clinicBooking.repository.BookingRepository;
import org.springframework.http.ResponseEntity;

public class BookingService {
    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }
    public ResponseEntity<?> addPatient(Booking patient) {
        if(bookingRepository.findById(patient.getPatientId()).isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        Booking booking = new Booking();
        booking.setFirstName(patient.getFirstName());
        booking.setLastName(patient.getLastName());
        booking.setPatientId(patient.getPatientId());
        bookingRepository.save(booking);
        return ResponseEntity.ok(booking);
    }
}
