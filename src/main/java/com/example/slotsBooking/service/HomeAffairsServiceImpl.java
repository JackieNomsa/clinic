package com.example.slotsBooking.service;

import com.example.slotsBooking.model.Booking;
import com.example.slotsBooking.repository.HomeAffairsBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HomeAffairsServiceImpl implements HomeAffairsService{
    @Autowired
    private final HomeAffairsBookingRepository homeAffairsBookingRepository;

    @Value("slots.service.url")
    String slotsUrl;

    public HomeAffairsServiceImpl(HomeAffairsBookingRepository homeAffairsBookingRepository) {
        this.homeAffairsBookingRepository = homeAffairsBookingRepository;
    }

    @Override
    public Booking createBooking(Booking patient) {
        if(this.homeAffairsBookingRepository.findById(patient.getPatientId()).isPresent()) {
            return null;
        }
        Booking booking = new Booking();
        booking.setFirstName(patient.getFirstName());
        booking.setLastName(patient.getLastName());
        booking.setPatientId(patient.getPatientId());
        booking.setStatus(patient.getStatus());
        this.homeAffairsBookingRepository.save(booking);
        return booking;
    }

    @Override
    public List<Booking> fetchBookingList() {
        return (List<Booking>) this.homeAffairsBookingRepository.findAll();
    }

    @Override
    public Booking updateBooking(String bookingId,String bookingReference) {
        Optional<Booking> booking1 = this.homeAffairsBookingRepository.findById(bookingId);
        if (booking1.isEmpty()){
            return null;
        }
        Booking updatedBooking = booking1.get();
        updatedBooking.setStatus("booked");
        updatedBooking.setBookingRef(bookingReference);
        this.homeAffairsBookingRepository.save(updatedBooking);
        return updatedBooking;
    }

    @Override
    public Booking getBookingById(String bookingId) {
        Optional<Booking> booking1 = this.homeAffairsBookingRepository.findById(bookingId);
        if (booking1.isEmpty()){
            return null;
        }
        //TODO
        // return a different model that also contains the date and time for the frontend ui
        return booking1.get();
    }

    @Override
    public Booking deleteBookingById(String bookingId) {
        Optional<Booking> booking1 = this.homeAffairsBookingRepository.findById(bookingId);
        if (booking1.isEmpty()){
            return null;
        }
        Booking deletedBooking = booking1.get();
        this.homeAffairsBookingRepository.delete(deletedBooking);
        //TODO
        // check that data on linked table cascades on delete and frees up slots oon the other api
        // on delete api should update slots api so that is marks the time as available
        return deletedBooking;
    }
}
