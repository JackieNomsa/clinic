package com.example.slotsBooking.service;

import com.example.slotsBooking.model.Booking;
import java.util.List;
public interface ClinicBookingService {
    Booking createBooking(Booking booking);
    List<Booking> fetchBookingList();
    Booking updateBooking(String bookingId, String bookingReference);
    Booking getBookingById(String bookingId);
    Booking deleteBookingById(Booking booking);
}
