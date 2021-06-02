package com.rcintra.tdd.booking;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookings")
public class BookController {

	@GetMapping
	@ResponseBody
	public String getAll() {
		return HttpStatus.OK.toString();
	}
	
	@PostMapping
	public ResponseEntity<Booking> save(@Validated @RequestBody Booking model) {
		return new ResponseEntity<Booking>(model, HttpStatus.CREATED);
	}
}
