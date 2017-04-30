package com.epam.cinema.service;

import java.util.Set;

import com.epam.cinema.model.Booking;
import com.epam.cinema.model.Person;

public interface BookingService {

	Long createBooking(Booking booking);

	void editBooking(Booking booking);

	Boolean setBooking(Long id, Person person);

	Boolean returnBooking(Long id);

	Booking getBookingById(Long id);

	void removeBookingById(Long id);

	Set<Booking> findBookings();

	Set<Booking> findBookedTickets();

}
