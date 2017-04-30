package com.epam.cinema.service.impl;

import java.util.HashSet;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;

import org.springframework.stereotype.Service;

import com.epam.cinema.model.Booking;
import com.epam.cinema.model.Person;
import com.epam.cinema.model.State;
import com.epam.cinema.service.BookingService;

@Service
public class DefaultBookingService implements BookingService {

	private static NavigableMap<Long, Booking> bookings = new TreeMap<Long, Booking>();

	public Long createBooking(Booking booking) {
		if (bookings.isEmpty()) {
			booking.setId(1L);
		} else {
			booking.setId(bookings.lastKey() + 1L);
		}
		booking.setState(State.FREE);
		bookings.put(booking.getId(), booking);
		return booking.getId();
	}

	public Boolean setBooking(Long id, Person person) {
		Booking booking = bookings.get(id);
		if ((booking == null) || (booking.getState().equals(State.BOOKED)))
			return false;
		booking.setClient(person);
		booking.setState(State.BOOKED);
		return true;
	}

	public Booking getBookingById(Long id) {
		return bookings.get(id);
	}

	public Boolean returnBooking(Long id) {
		if (bookings.get(id) == null)
			return false;
		Booking booking = bookings.get(id);
		booking.setState(State.FREE);
		booking.setClient(null);
		;
		return true;
	}

	public void editBooking(Booking booking) {
		booking.setState(State.FREE);
		bookings.put(booking.getId(), booking);
	}

	public void removeBookingById(Long id) {
		bookings.remove(id);
	}

	public Set<Booking> findBookings() {
		Set<Booking> freeBookingByDate = new HashSet<Booking>();
		for (Booking booking : bookings.values()) {
			if (booking.getState().equals(State.FREE)) {
				freeBookingByDate.add(booking);
			}
		}
		return freeBookingByDate;
	}

	@Override
	public Set<Booking> findBookedTickets() {
		Set<Booking> bookedTickets = new HashSet<Booking>();
		for (Booking booking : bookings.values()) {
			if (booking.getState().equals(State.BOOKED)) {
				bookedTickets.add(booking);
			}
		}
		return bookedTickets;
	}
}
