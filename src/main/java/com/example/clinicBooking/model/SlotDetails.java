package com.example.clinicBooking.model;

import java.util.Date;

public class SlotDetails {
    private String _id;
    private Date createdAt;
    private Date updatedAt;
    private String reference;
    private String time;
    private String location;
    private boolean booked;
    private String type;

    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }
    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    public Date getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
    public String getReference() {
        return reference;
    }
    public void setReference(String reference) {
        this.reference = reference;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public boolean isBooked() {
        return booked;
    }
    public void setBooked(boolean booked) {
        this.booked = booked;
    }
    public Date getDate() {
        return updatedAt;
    }
    public void setDate(Date date) {
        this.updatedAt = date;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
}
