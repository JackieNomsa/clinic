package com.example.clinicBooking.model;

import java.util.Date;

public class SlotDetails {
    public SlotDetails(){}

    public SlotDetails(Long referenceNumber, Date date){
        this.date = date;
        this.referenceNumber = referenceNumber;

    }
    private Date date;
    private Long referenceNumber;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(Long referenceNumber) {
        this.referenceNumber = referenceNumber;
    }
}
