package com.example.clinicBooking.service;

import com.example.clinicBooking.model.Booking;
import com.example.clinicBooking.model.BookingDetails;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpRequest;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
    public List<Date> getAvailableSlots() {
        RestTemplate restTemplate = new RestTemplate();

        String uri = "http://localhost:8081/slots";

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>("", headers);
        ResponseEntity<?> result =
                restTemplate.exchange(uri, HttpMethod.GET, entity, Map.class);
        return (List<Date>) result.getBody();
    }
}
