package com.example.clinicBooking.service;

import com.example.clinicBooking.model.Booking;
import com.example.clinicBooking.repository.BookingRepository;
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
public class BookingServiceTests {
    @Mock
    private BookingRepository bookingRepository;
    private BookingServiceImp bookingService;
    private DetailsServiceImp detailsServiceImp;
    Booking booking;

    @BeforeEach void setUp() {
        this.bookingService = new BookingServiceImp(this.bookingRepository);
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
    void testDeleteBookingDoesNotExist(){
        Booking testBooking = bookingService.getBookingById("1234567890345");
        Mockito.when(bookingRepository.findById(any()))
                .thenReturn(Optional.ofNullable(testBooking));
        assertNull(bookingService.deleteBookingById("12345"));
        assertEquals(testBooking,bookingService.deleteBookingById("1234567890345"));
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
        assertEquals("booked",updateBooking.getLastName());
        assertEquals("1234567890345",updateBooking.getPatientId());
        assertEquals("43456",updateBooking.getBookingRef());


    }
}
