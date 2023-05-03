package com.example.clinicBooking.service;

import com.example.clinicBooking.model.Booking;
import com.example.clinicBooking.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Component
@Transactional
public class BookingServiceImp implements BookingService{
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
        bookingRepository.save(booking);
        return booking;
    }

    @Override
    public List<Booking> fetchBookingList() {
        return (List<Booking>) bookingRepository.findAll();
    }

    @Override
    public Booking updateBooking(Booking booking, String bookingId) {
        Optional<Booking> booking1 = bookingRepository.findById(bookingId);
        if (booking1.isEmpty()){
            return null;
        }
        return booking1.get();
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
    public void deleteBookingById(String bookingId) {

    }
}
