package com.example.clinicBooking.service;

import com.example.clinicBooking.model.Booking;
import java.util.List;
public interface BookingService {
    Booking createBooking(Booking booking);
    List<Booking> fetchBookingList();
    Booking updateBooking(Booking booking);
    Booking getBookingById(String bookingId);
    Booking deleteBookingById(String bookingId);
}
