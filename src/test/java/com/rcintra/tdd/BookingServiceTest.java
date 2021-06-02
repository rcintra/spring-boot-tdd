package com.rcintra.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.rcintra.tdd.booking.BookService;
import com.rcintra.tdd.booking.Booking;
import com.rcintra.tdd.booking.BookingRepository;

@SpringBootTest
public class BookingServiceTest {

	@Autowired
	private BookService bookService;

	@MockBean
	private BookingRepository bookingRepository;
	
	@BeforeEach
	void setMockOutput() {
		LocalDate checkIn = LocalDate.parse("2020-11-10");
		LocalDate checkOut = LocalDate.parse("2020-11-20");
		Booking book = new Booking(1l, "Rafael", checkIn, checkOut, 2);
		
		when(bookingRepository.findByReserveName(book.getReserveName()))
		.thenReturn(Optional.of(book));
	}

	@DisplayName("Test Booking Days Calculator")
	@Test
	public void bookingTestServiceDaysCalculator() {
		String name = "Rafael";
		int days = bookService.daysCalculatorWithDatabase(name);
		
		assertEquals(days, 10);
		
	}
	
	@DisplayName("Test Booking Days Calculator With Days Error")
	@Test
	public void bookingTestServiceDaysCalculatorWithError() {
		String name = "Rafael";
		int days = bookService.daysCalculatorWithDatabase(name);
		
		assertNotEquals(days, 11);
		
	}
	
	
	
}