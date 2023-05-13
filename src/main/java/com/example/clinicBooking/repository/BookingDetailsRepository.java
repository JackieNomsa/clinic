package com.example.clinicBooking.repository;

import com.example.clinicBooking.model.BookingDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingDetailsRepository extends CrudRepository<BookingDetails, String> {
}
