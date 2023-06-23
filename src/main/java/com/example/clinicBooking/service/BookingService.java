package com.example.clinicBooking.service;

import com.example.clinicBooking.model.Booking;
import java.util.List;
public interface BookingService {
    Booking createBooking(Booking booking);
    List<Booking> fetchBookingList();
    Booking updateBooking(String bookingId, String bookingReference);
    Booking getBookingById(String bookingId);
    Booking deleteBookingById(String bookingId);
}
