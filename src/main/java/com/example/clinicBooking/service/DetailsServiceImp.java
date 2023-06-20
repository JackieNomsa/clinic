package com.example.clinicBooking.service;

import com.example.clinicBooking.model.Booking;
import com.example.clinicBooking.model.SlotDetails;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class DetailsServiceImp implements DetailsService{

    @Override
    public SlotDetails getBookingDetails(String id) {
        //TODO:
        //make call to external api and thor an error if BookingDetails is null
        return null;
    }

    @Override
    public SlotDetails deleteBooking(String id) {
        //TODO:
        //Delete booking if exists and throw an error if not, delete must cascade
        return null;
    }

    @Override
    public SlotDetails createBookingSlot(Booking booking) {
        return null;
    }

    @Override
    public SlotDetails[] getAvailableSlots() {
        RestTemplate restTemplate = new RestTemplate();
        try {
            String url = "http://localhost:8081/slots";
            return restTemplate.getForObject(url, SlotDetails[].class);
        }catch (RestClientException e){
            return null;
        }
    }
}
