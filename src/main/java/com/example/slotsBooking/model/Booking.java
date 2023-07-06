package com.example.slotsBooking.model;


import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="clinic_booking")
public class Booking implements Serializable {

    @Id
    @Column(name="patient_id")
    private String patientId;

    @Column(name="first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "status")
    private String status;

    @Column(name = "booking_ref")
    private String booking_ref;

    public String getBookingRef() {
        return booking_ref;
    }

    public void setBookingRef(String booking_ref) {
        this.booking_ref = booking_ref;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
