package com.example.slotsBooking.service;

import com.example.slotsBooking.model.Booking;
import com.example.slotsBooking.repository.ClinicBookingRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ClinicBookingServiceTests {
    @Mock
    private ClinicBookingRepository bookingRepository;
    @Mock
    private ClinicBookingServiceImp bookingService;
    @Mock
    private DetailsServiceImp detailsServiceImp;

    Booking booking;

    @BeforeEach void setUp() {
        this.bookingService = new ClinicBookingServiceImp(this.bookingRepository,this.detailsServiceImp);
        this.booking = new Booking();
        this.booking.setStatus("waiting");
        this.booking.setFirstName("test");
        this.booking.setLastName("tested");
        this.booking.setPatientId("1234567890345");
    }
    @Test
    void testCreateBooking(){
        Booking booking1 = bookingService.createBooking(booking);
        assert Objects.equals(booking1.getFirstName(), booking.getFirstName());
        assertEquals("1234567890345",booking.getPatientId());
    }

    @Test
    void testCreateBookingFailsIfValueExists(){
        Mockito.when(bookingRepository.findById(any()))
                .thenReturn(Optional.ofNullable(booking));
        Booking testBooking = bookingService.getBookingById("1234567890345");
        assertNotNull(testBooking);
        Booking testCreateBooking = bookingService.createBooking(testBooking);
        assertNull(testCreateBooking);
    }

    @Test
    void testFetchAllBookings(){
        List<Booking> bookings = List.of(booking);
        Mockito.when(bookingRepository.findAll())
        .thenReturn(bookings);
        assertEquals(1,bookingService.fetchBookingList().size());
        assertEquals("test",bookingService.fetchBookingList().get(0).getFirstName());
    }

    @Test
    void testDeleteBooking(){
        Mockito.when(bookingRepository.findById("1234567890345"))
                .thenReturn(Optional.ofNullable(booking));
        assertEquals(booking,bookingService.deleteBookingById(booking));
    }

    @Test
    void testGetBookingById(){
        Mockito.when(bookingRepository.findById(any()))
                .thenReturn(Optional.ofNullable(booking));
        Booking testBooking = bookingService.getBookingById("1234567890345");
        assertNotNull(testBooking);
        assertEquals("waiting",testBooking.getStatus());
    }

    @Test
    void testGetOneReturnsNull(){
        Booking testBooking = bookingService.getBookingById("1234567890345");
        assertNull(testBooking);
    }

    @Test
    void testUpdateBooking(){
        Mockito.when(bookingRepository.findById(any()))
                .thenReturn(Optional.ofNullable(booking));
        Booking testBooking = bookingService.getBookingById("1234567890345");
        assert testBooking != null;
        Booking updateBooking = bookingService.updateBooking(testBooking.getPatientId(),"43456");
        assertEquals("1234567890345",updateBooking.getPatientId());

    }
}
