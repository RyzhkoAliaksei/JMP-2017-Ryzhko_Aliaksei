package com.epam.cinema.DAO;

import java.util.Set;

import com.epam.cinema.model.Booking;
import com.epam.cinema.model.Person;

public interface BookingDAO {

	Long createBooking(Booking booking);

	void editBooking(Booking booking);

	Boolean setBooking(Long id, Person person);

	Boolean returnBooking(Long id);

	Booking getBookingById(Long id);

	void removeBookingById(Long id);

	Set<Booking> findBookings();

	Set<Booking> findBookedTickets();

}
