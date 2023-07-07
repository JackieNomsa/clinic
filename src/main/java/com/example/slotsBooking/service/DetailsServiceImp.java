package com.example.slotsBooking.service;

import com.example.slotsBooking.model.Booking;
import com.example.slotsBooking.model.BookingType;
import com.example.slotsBooking.model.SlotDetails;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class DetailsServiceImp implements DetailsService{
    @Value("slots.service.url")
    String slotsUrl;
    RestTemplate restTemplate;
    @Override
    public SlotDetails getBookingDetails(String id,String type) {
        return new RestTemplate().getForObject(this.slotsUrl.concat(type).concat(id), SlotDetails.class);
    }

    @Override
    public SlotDetails deleteBooking(String id,String type) {
        return new RestTemplate().getForObject(this.slotsUrl.concat(type).concat("/delete/"+id), SlotDetails.class);
    }

    @Override
    public SlotDetails createBookingSlot(Booking booking,SlotDetails slotDetails,String type) {
        return new RestTemplate().getForObject(this.slotsUrl.concat(type).concat("/create/"), SlotDetails.class);
    }

    @Override
    public SlotDetails[] getAvailableSlots(String type) {
        return new RestTemplate().getForObject(this.slotsUrl.concat("homeaffairs"), SlotDetails[].class);
    }
}
