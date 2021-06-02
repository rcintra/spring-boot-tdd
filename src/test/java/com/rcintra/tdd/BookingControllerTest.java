package com.rcintra.tdd;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rcintra.tdd.booking.Booking;

@SpringBootTest
@AutoConfigureMockMvc
public class BookingControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper; 

	@Test
	public void bookingTestGetAll() throws Exception {
		mockMvc.perform(get("/bookings"))
				.andExpect(status().isOk());
	}
	
	@Test
	public void bookingTestSave() throws Exception {
		LocalDate checkIn = LocalDate.parse("2020-11-10");
		LocalDate checkOut = LocalDate.parse("2020-11-20");
		Booking book = new Booking(1l, "Rafael", checkIn, checkOut, 2);
		
		mockMvc.perform(post("/bookings")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(book)))
				.andExpect(status().isCreated())
				.andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
		
	}
}
