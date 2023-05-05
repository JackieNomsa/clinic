package com.example.clinicBooking.service;

import com.example.clinicBooking.model.Booking;
import com.example.clinicBooking.repository.BookingRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = BookingServiceImp.class)
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application-integration-test.properties")
public class BookingServiceTests {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private BookingRepository bookingRepository;

    @TestConfiguration
    static class BookingServiceImplTestContextConfiguration {
        @Bean
        public BookingService employeeService() {
            return new BookingService() {
                @Override
                public Booking createBooking(Booking booking) {
                    return null;
                }

                @Override
                public List<Booking> fetchBookingList() {
                    return null;
                }

                @Override
                public Booking updateBooking(Booking booking) {
                    return null;
                }

                @Override
                public Booking getBookingById(String bookingId) {
                    return null;
                }

                @Override
                public Booking deleteBookingById(String bookingId) {
                    return null;
                }
            };
        }
    }
    @Test
    void testCreateBooking(){

    }

    @Test
    void testFetchAllBookings(){

    }

    @Test
    void testDeleteBooking(){

    }

    @Test
    void testGetBookingById(){

    }

    @Test
    void testUpdateBooking(){

    }
}
