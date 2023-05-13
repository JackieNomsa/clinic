package com.example.clinicBooking.service;

import com.example.clinicBooking.model.Booking;
import com.example.clinicBooking.repository.BookingDetailsRepository;
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
    private final BookingDetailsRepository bookingDetailsRepository;
    @Autowired
    public BookingServiceImp(BookingRepository bookingRepository, BookingDetailsRepository bookingDetailsRepository) {
        this.bookingRepository = bookingRepository;
        this.bookingDetailsRepository = bookingDetailsRepository;
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
        //TODO
        // add external call to slots api and get an available time to assign to user
        // if no slot available set status as waiting
        // maybe make the call first and give the user a choice if more than one option available
        // if only one option available book it
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
        //TODO
        // return a different model that also contains the date and time for the frontend ui
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
        //TODO
        // check that data on linked table cascades on delete and frees up slots oon the other api
        // on delete api should update slots api so that is marks the time as available
        return deletedBooking;
    }
}
