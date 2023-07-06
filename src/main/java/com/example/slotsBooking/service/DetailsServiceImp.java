package com.example.slotsBooking.service;

import com.example.slotsBooking.model.Booking;
import com.example.slotsBooking.model.SlotDetails;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class DetailsServiceImp implements DetailsService{
    @Value("slots.service.url")
    String slotsUrl;
    @Override
    public SlotDetails getBookingDetails(String id,String type) {
        SlotDetails slotDetails;
        RestTemplate restTemplate = new RestTemplate();
        try {
            return restTemplate.getForObject(this.slotsUrl.concat(type).concat(id), SlotDetails.class);
        }catch (RestClientException e){
            return null;
        }
    }

    @Override
    public SlotDetails deleteBooking(String id,String type) {
        //TODO:
        //Delete booking if exists and throw an error if not, delete must cascade
        return null;
    }

    @Override
    public SlotDetails createBookingSlot(Booking booking,String type) {
        return null;
    }

    @Override
    public SlotDetails[] getAvailableSlots(String type) {
        RestTemplate restTemplate = new RestTemplate();
        try {
            return restTemplate.getForObject(this.slotsUrl.concat(type), SlotDetails[].class);
        }catch (RestClientException e){
            return null;
        }
    }
}
