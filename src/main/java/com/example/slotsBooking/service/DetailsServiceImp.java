package com.example.slotsBooking.service;

import com.example.slotsBooking.model.Booking;
import com.example.slotsBooking.model.SlotDetails;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class DetailsServiceImp implements DetailsService{
    @Value("slots.service.url")
    String slotsUrl;
    @Override
    public SlotDetails getBookingDetails(String id,String type) {
        return new RestTemplate().getForObject(this.slotsUrl.concat(type).concat(id), SlotDetails.class);
    }

    @Override
    public SlotDetails deleteBooking(String id,String type) {
        ObjectMapper mapper = new ObjectMapper();
        SlotDetails slotDetails = this.getBookingDetails(id,type);
        slotDetails.setBooked(false);
        slotDetails.setReference("");
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        Map map = new HashMap<String, String>();
        map.put("Content-Type", "application/json");
        headers.setAll(map);
        try {
            String req_payload = mapper.writeValueAsString(slotDetails);
            HttpEntity<?> request = new HttpEntity<>(req_payload, headers);
            new RestTemplate().postForEntity(this.slotsUrl.concat(type).concat("/update/"), request, SlotDetails.class);
        }catch (JsonProcessingException e){
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public SlotDetails createBookingSlot(Booking booking,String type) {
        ObjectMapper mapper = new ObjectMapper();
        SlotDetails[] slotDetailsList = this.getAvailableSlots(type);
        if(slotDetailsList.length > 1){
            SlotDetails bookingSlot = slotDetailsList[0];
            booking.setBookingRef(bookingSlot.getReference());
            bookingSlot.setReference(booking.getPatientId());
            bookingSlot.setBooked(true);
            MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
            Map map = new HashMap<String, String>();
            map.put("Content-Type", "application/json");
            headers.setAll(map);
            try {
                String req_payload = mapper.writeValueAsString(bookingSlot);
                HttpEntity<?> request = new HttpEntity<>(req_payload, headers);
                ResponseEntity<SlotDetails>  slotDetailsResponseEntity = new RestTemplate()
                        .postForEntity(this.slotsUrl.concat(type).concat("/update/"),request, SlotDetails.class);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    @Override
    public SlotDetails[] getAvailableSlots(String type) {
        return new RestTemplate().getForObject(this.slotsUrl.concat(type), SlotDetails[].class);
    }
}
