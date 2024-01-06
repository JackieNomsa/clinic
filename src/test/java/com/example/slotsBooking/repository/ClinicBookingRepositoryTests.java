package com.example.slotsBooking.repository;

import com.example.slotsBooking.model.Booking;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

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
        Assertions.assertEquals(savedBooking,booking);

    }

    @Test
    public void getAllClinicBookings(){

    }
}
