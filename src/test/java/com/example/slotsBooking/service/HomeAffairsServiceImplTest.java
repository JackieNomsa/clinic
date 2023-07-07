package com.example.slotsBooking.service;

import com.example.slotsBooking.model.Booking;
import com.example.slotsBooking.repository.HomeAffairsBookingRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class HomeAffairsServiceImplTest {
    @Mock
    private HomeAffairsBookingRepository bookingRepository;
    @Mock
    private HomeAffairsService bookingService;
    Booking booking;

    @BeforeEach
    void setUp() {
        this.bookingService = new HomeAffairsServiceImpl(this.bookingRepository);
        this.booking = new Booking();
        this.booking.setStatus("waiting");
        this.booking.setFirstName("test");
        this.booking.setLastName("tested");
        this.booking.setPatientId("1234567890345");
    }

    @Test
    void createBooking() {
    }

    @Test
    void fetchBookingList() {
    }

    @Test
    void updateBooking() {
    }

    @Test
    void getBookingById() {
    }

    @Test
    void deleteBookingById() {
    }
}