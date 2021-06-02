package com.rcintra.tdd.booking;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {	

	Optional<Booking> findByReserveName(String name);
	
}
