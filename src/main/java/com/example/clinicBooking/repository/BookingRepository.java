package com.example.clinicBooking.repository;
import com.example.clinicBooking.model.Booking;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends CrudRepository<Booking, String> {

}
