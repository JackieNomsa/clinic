package com.example.slotsBooking.service;

import com.example.slotsBooking.model.Booking;
import com.example.slotsBooking.model.BookingType;
import com.example.slotsBooking.model.SlotDetails;

public interface DetailsService {

    SlotDetails getBookingDetails(String id,String type);
    SlotDetails deleteBooking(String id,String type);
    SlotDetails createBookingSlot(Booking booking,SlotDetails slotDetails,String type);
    SlotDetails[] getAvailableSlots(String type);
}
