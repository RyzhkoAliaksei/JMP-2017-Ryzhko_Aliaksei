package com.epam.cinema.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.cinema.DAO.BookingDAO;
import com.epam.cinema.model.Booking;
import com.epam.cinema.model.Person;
import com.epam.cinema.service.BookingService;

@Service
public class DefaultBookingService implements BookingService {

	@Autowired
	private BookingDAO bookingDAO;

	public Boolean setBooking(Long id, Person person) {
		return bookingDAO.setBooking(id, person);
	}

	public Booking getBookingById(Long id) {
		return bookingDAO.getBookingById(id);
	}

	public Boolean returnBooking(Long id) {

		return bookingDAO.returnBooking(id);
	}

	public Set<Booking> findBookings() {
		return bookingDAO.findBookings();
	}

	@Override
	public Set<Booking> findBookedTickets() {

		return bookingDAO.findBookedTickets();
	}
	
	
	public long calculateMethodForUnitTest(int a,int b) {
		if (b == 0)
			throw new IllegalArgumentException("Division by zero!");
		else
			return a/b;
	}
	public void simulateProcessingTimeoutForUnitTest() throws InterruptedException {
		int [] numbers = {10, 20, 30, 40, 50};
		 for(int x : numbers){
	//		 Thread.sleep(1000); 
	         System.out.print( x );
	      }
	}
}
