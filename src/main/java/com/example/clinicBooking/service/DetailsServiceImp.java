package com.example.clinicBooking.service;

import com.example.clinicBooking.model.Booking;
import com.example.clinicBooking.model.BookingDetails;
import com.example.clinicBooking.model.SlotDetails;
import org.springframework.http.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpRequest;
import java.util.*;

public class DetailsServiceImp implements DetailsService{

    @Override
    public BookingDetails getBookingDetails(String id) {
        //TODO:
        //make call to external api and thor an error if BookingDetails is null
        return null;
    }

    @Override
    public BookingDetails deleteBooking(String id) {
        //TODO:
        //Delete booking if exists and throw an error if not, delete must cascade
        return null;
    }

    @Override
    public BookingDetails createBookingSlot(Booking booking) {
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
