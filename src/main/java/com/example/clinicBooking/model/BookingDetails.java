package com.example.clinicBooking.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="booking_details")
public class BookingDetails {
    //must contain user id and reference number from slots_management service to assign a time slot

    @Id
    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private String id;

    @Column(name = "reference")
    private Long reference;

    @Column(name = "time")
    private Date time;

    @Column(name = "address")
    private String address;
}
