package com.example.clinicBooking.service;

import com.example.clinicBooking.model.Booking;
import com.example.clinicBooking.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@ComponentScan(basePackages = { "com.example.clinicBooking.*" })
@EntityScan("com.example.clinicBooking.*")
@Service
public class BookingServiceImp implements BookingService{
    @Autowired
    private final BookingRepository bookingRepository;
    @Autowired
    public BookingServiceImp(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public Booking createBooking(Booking patient) {
        if(bookingRepository.findById(patient.getPatientId()).isPresent()) {
            return null;
        }
        Booking booking = new Booking();
        booking.setFirstName(patient.getFirstName());
        booking.setLastName(patient.getLastName());
        booking.setPatientId(patient.getPatientId());
        booking.setStatus(patient.getStatus());
        bookingRepository.save(booking);
        return booking;
    }

    @Override
    public List<Booking> fetchBookingList() {
        return (List<Booking>) bookingRepository.findAll();
    }

    @Override
    public Booking updateBooking(Booking booking) {
        Optional<Booking> booking1 = bookingRepository.findById(booking.getPatientId());
        if (booking1.isEmpty()){
            return null;
        }
        Booking updatedBooking = booking1.get();
        updatedBooking.setStatus(booking.getStatus());
        bookingRepository.save(updatedBooking);
        return updatedBooking;
    }

    @Override
    public Booking getBookingById(String bookingId) {
        Optional<Booking> booking1 = bookingRepository.findById(bookingId);
        if (booking1.isEmpty()){
            return null;
        }
        return booking1.get();
    }

    @Override
    public Booking deleteBookingById(String bookingId) {
        Optional<Booking> booking1 = bookingRepository.findById(bookingId);
        if (booking1.isEmpty()){
            return null;
        }
        Booking deletedBooking = booking1.get();
        bookingRepository.delete(deletedBooking);
        return deletedBooking;
    }
}
