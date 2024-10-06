package com.example.slotsBooking.repository;

import com.example.slotsBooking.model.Booking;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2, replace = AutoConfigureTestDatabase.Replace.NONE)
public class ClinicBookingRepositoryTests {

    @Autowired
    public ClinicBookingRepository clinicBookingRepository;

    @Test
    public void testSaveBooking(){
        //Arrange
        Booking booking = Booking.builder()
                .firstName("test")
                .lastName("testing")
                .patientId("123456")
                .status("booked")
                .build();

        //Act
        Booking savedBooking = clinicBookingRepository.save(booking);

        //Assert
        Assertions.assertEquals(savedBooking.getPatientId(),booking.getPatientId());

    }

    @Test
    public void testFindBookingByPatientId(){
        Booking booking = Booking.builder()
                .firstName("test")
                .lastName("testing")
                .patientId("123458")
                .status("booked")
                .build();
        clinicBookingRepository.save(booking);
        Booking booking2 = Booking.builder()
                .firstName("test2")
                .lastName("testing2")
                .patientId("778644")
                .status("booked")
                .build();
        clinicBookingRepository.save(booking2);

        Optional<Booking> bookingById = clinicBookingRepository.getByPatientId("123458");
        Assertions.assertEquals(bookingById.get().getPatientId(),booking.getPatientId());

    }

    @Test
    public void getAllClinicBookings(){
        Booking booking = Booking.builder()
                .firstName("test")
                .lastName("testing")
                .patientId("123458")
                .status("booked")
                .build();
        clinicBookingRepository.save(booking);
        Booking booking2 = Booking.builder()
                .firstName("test2")
                .lastName("testing2")
                .patientId("778644")
                .status("booked")
                .build();
        clinicBookingRepository.save(booking2);

        List<Booking> bookings = (List<Booking>) clinicBookingRepository.findAll();
        Assertions.assertNotNull(bookings, "booking is empty");
        Assertions.assertEquals(2, bookings.size());
    }
}
