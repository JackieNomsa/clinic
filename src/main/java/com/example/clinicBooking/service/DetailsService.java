package com.example.clinicBooking.service;

import com.example.clinicBooking.model.Booking;
import com.example.clinicBooking.model.BookingDetails;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface DetailsService {

    BookingDetails getBookingDetails(String id);
    BookingDetails deleteBooking(String id);
    BookingDetails createBookingSlot(Booking booking);
    Map<String, Date> getAvailableSlots();
}
