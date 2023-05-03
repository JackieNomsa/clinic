package com.example.clinicBooking.repository;
import com.example.clinicBooking.model.Booking;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@AutoConfiguration
public interface BookingRepository extends CrudRepository<Booking, String> {

}
