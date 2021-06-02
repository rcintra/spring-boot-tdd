package com.rcintra.tdd.booking;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Booking implements Serializable {

	private static final long serialVersionUID = 8217960008459031668L;
	@Id
	@GeneratedValue
	private Long id;
	private String reserveName;
	private LocalDate checkIn;
	private LocalDate checkOut;
	private int numberGuest;
	
	public Booking(Long id, String reserveName, LocalDate checkIn, LocalDate checkOut, int numberGuest) {
		super();
		this.id = id;
		this.reserveName = reserveName;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.numberGuest = numberGuest;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getReserveName() {
		return reserveName;
	}
	public void setReserveName(String reserveName) {
		this.reserveName = reserveName;
	}
	public LocalDate getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(LocalDate checkIn) {
		this.checkIn = checkIn;
	}
	public LocalDate getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(LocalDate checkOut) {
		this.checkOut = checkOut;
	}
	public int getNumberGuest() {
		return numberGuest;
	}
	public void setNumberGuest(int numberGuest) {
		this.numberGuest = numberGuest;
	}
	
	
}
