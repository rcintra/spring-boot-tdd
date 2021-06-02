package com.rcintra.tdd.booking;

import java.time.Period;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	BookingRepository bookingRepository;

	@Override
	public int daysCalculatorWithDatabase(String name) {
		Optional<Booking> bookingModelOptional = bookingRepository.findByReserveName(name);

		return Period.between(bookingModelOptional.get().getCheckIn(), bookingModelOptional.get().getCheckOut())
				.getDays();
	}

}
