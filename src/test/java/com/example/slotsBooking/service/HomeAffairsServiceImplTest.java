package com.example.slotsBooking.service;

import com.example.slotsBooking.model.Booking;
import com.example.slotsBooking.repository.HomeAffairsBookingRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
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
    void testCreateBooking() {
        Booking booking1 = bookingService.createBooking(booking);
        assert Objects.equals(booking1.getFirstName(), booking.getFirstName());
        assertEquals("1234567890345",booking.getPatientId());
    }

    @Test
    void testFetchBookingList() {
        assertEquals(ArrayList .class, bookingService.fetchBookingList().getClass());
    }

    @Test
    void testUpdateBooking() {
        Mockito.when(bookingRepository.findById(any()))
                .thenReturn(Optional.ofNullable(booking));
        Booking testBooking = bookingService.getBookingById("1234567890345");
        assert testBooking != null;
        Booking updateBooking = bookingService.updateBooking(testBooking.getPatientId(),"43456");
        assertEquals("booked",updateBooking.getStatus());
    }

    @Test
    void testGetBookingById() {
        Mockito.when(bookingRepository.findById(any()))
                .thenReturn(Optional.ofNullable(booking));
        assertNotNull(bookingService.getBookingById("1234567890345"));
    }

    @Test
    void testDeleteBookingById() {
        Mockito.when(bookingRepository.findById(any()))
                .thenReturn(Optional.ofNullable(booking));
        assertNotNull(bookingService.deleteBookingById("1234567890345"));
    }
}