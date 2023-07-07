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
        SlotDetails slotDetails;
        restTemplate = new RestTemplate();
        try {
            return restTemplate.getForObject(this.slotsUrl.concat(type).concat(id), SlotDetails.class);
        }catch (RestClientException e){
            return null;
        }
    }

    @Override
    public SlotDetails deleteBooking(String id,String type) {
        restTemplate = new RestTemplate();
        try {
            return restTemplate.getForObject(this.slotsUrl.concat(type).concat("/delete/"+id), SlotDetails.class);
        }catch (RestClientException e){
            return null;
        }
    }

    @Override
    public Booking createBookingSlot(Booking booking,SlotDetails slotDetails,String type) {
        //TODO
        // add reference to slot detail / Booking
        // update booking status
        return null;
    }

    @Override
    public SlotDetails[] getAvailableSlots(BookingType type) {
        RestTemplate restTemplate = new RestTemplate();
        try {
            if(type.equals(BookingType.HOMEAFFAIRS)) {
                return restTemplate.getForObject(this.slotsUrl.concat("homeaffairs"), SlotDetails[].class);
            }else{
                return restTemplate.getForObject(this.slotsUrl.concat("clinic"), SlotDetails[].class);
            }
        }catch (RestClientException e){
            return null;
        }
    }
}
