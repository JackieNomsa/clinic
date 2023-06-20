package com.example.clinicBooking.service;

import com.example.clinicBooking.model.Booking;
import com.example.clinicBooking.model.SlotDetails;

public interface DetailsService {

    SlotDetails getBookingDetails(String id);
    SlotDetails deleteBooking(String id);
    SlotDetails createBookingSlot(Booking booking);
    SlotDetails[] getAvailableSlots();
}
