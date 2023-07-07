package com.example.slotsBooking.service;

import com.example.slotsBooking.model.Booking;
import com.example.slotsBooking.model.SlotDetails;
import com.example.slotsBooking.repository.ClinicBookingRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClinicBookingServiceImp implements ClinicBookingService {
    private final ClinicBookingRepository clinicBookingRepository;
    private final DetailsServiceImp detailsServiceImp;
    @Value("slots.service.url")
    String slotsUrl;
    public ClinicBookingServiceImp(ClinicBookingRepository bookingRepository, DetailsServiceImp detailsServiceImp) {
        this.clinicBookingRepository = bookingRepository;
        this.detailsServiceImp = detailsServiceImp;
    }

    @Override
    public Booking createBooking(Booking patient) {
        if(clinicBookingRepository.findById(patient.getPatientId()).isPresent()) {
            return null;
        }
        Booking booking = new Booking();
        booking.setFirstName(patient.getFirstName());
        booking.setLastName(patient.getLastName());
        booking.setPatientId(patient.getPatientId());
        booking.setStatus(patient.getStatus());
        booking.setBookingRef(patient.getBookingRef());
        clinicBookingRepository.save(booking);
        return booking;
    }

    @Override
    public List<Booking> fetchBookingList() {
        return (List<Booking>) clinicBookingRepository.findAll();
    }

    @Override
    public Booking updateBooking(String bookingId,String bookingReference) {
        Optional<Booking> booking1 = clinicBookingRepository.findById(bookingId);
        if (booking1.isEmpty()){
            return null;
        }
        Optional<SlotDetails> slotDetails = Optional.ofNullable(detailsServiceImp.getBookingDetails(bookingReference, "clinic"));
        Booking updatedBooking = booking1.get();
        if (slotDetails.isPresent()) {
            updatedBooking.setStatus("booked");
            updatedBooking.setBookingRef(bookingReference);
            clinicBookingRepository.save(updatedBooking);
        }
        return updatedBooking;
    }

    @Override
    public Booking getBookingById(String bookingId) {
        Optional<Booking> booking1 = clinicBookingRepository.findById(bookingId);
        if (booking1.isEmpty()){
            return null;
        }
        return booking1.get();
    }

    @Override
    public Booking deleteBookingById(Booking booking) {
        Optional<Booking> optionalBooking = clinicBookingRepository.findById(booking.getPatientId());
        if(optionalBooking.isEmpty()){
            return null;
        }else{
            clinicBookingRepository.delete(booking);
            Optional<SlotDetails> slotDetails = Optional.ofNullable(detailsServiceImp.getBookingDetails(booking.getBookingRef(), "clinic"));
            slotDetails.ifPresent(details -> detailsServiceImp.deleteBooking(details.get_id(), "clinic"));
            return booking;
        }

    }
}
