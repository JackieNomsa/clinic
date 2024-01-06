package com.example.slotsBooking.repository;
import com.example.slotsBooking.model.Booking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClinicBookingRepository extends CrudRepository<Booking, String> {
}
