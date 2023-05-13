package com.example.clinicBooking.model;


import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="clinic_booking")
public class Booking implements Serializable {

    @Id
    @OneToOne(mappedBy = "id", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    @Column(name="patient_id")
    private String patientId;

    @Column(name="first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "status")
    private String status;

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
