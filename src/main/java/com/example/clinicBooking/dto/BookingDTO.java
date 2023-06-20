package com.example.clinicBooking.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingDTO {
    private String patientId;
    private String firstName;
    private String lastName;
    private String status;
    private String booking_reference;
}
