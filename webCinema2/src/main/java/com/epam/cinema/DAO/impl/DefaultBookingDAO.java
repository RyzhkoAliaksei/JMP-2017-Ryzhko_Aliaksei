package com.epam.cinema.DAO.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;

import org.springframework.stereotype.Repository;

import com.epam.cinema.DAO.BookingDAO;
import com.epam.cinema.model.Booking;
import com.epam.cinema.model.Person;
import com.epam.cinema.model.State;

@Repository
public class DefaultBookingDAO implements BookingDAO {

	private static NavigableMap<Long, Booking> bookings = new TreeMap<Long, Booking>();
	static {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		Date date;
		try {
			date = dateFormat.parse("2017/03/25 09:00");
			Booking booking = new Booking();
			booking.setId(1L);
			booking.setFilmName("Star Wars");
			booking.setSeat(1);
			booking.setPrice(10.0);
			booking.setDate(date);
			booking.setState(State.FREE);
			Booking booking1 = new Booking();
			booking1.setId(2L);
			booking1.setFilmName("Star Wars");
			booking1.setSeat(2);
			booking1.setPrice(10.0);
			booking1.setDate(date);
			booking1.setState(State.FREE);
			Booking booking2 = new Booking();
			booking2.setId(3L);
			booking2.setFilmName("Crow");
			booking2.setSeat(3);
			booking2.setPrice(20.0);
			booking2.setDate(date);
			booking2.setState(State.FREE);
			bookings.put(booking.getId(), booking);
			bookings.put(booking1.getId(), booking1);
			bookings.put(booking2.getId(), booking2);
		} catch (ParseException e) {
			e.printStackTrace();
		}

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

	public Set<Booking> findBookings() {
		Set<Booking> freeBooking = new HashSet<Booking>();
		for (Booking booking : bookings.values()) {
			if (booking.getState().equals(State.FREE)) {
				freeBooking.add(booking);
			}
		}
		return freeBooking;
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
