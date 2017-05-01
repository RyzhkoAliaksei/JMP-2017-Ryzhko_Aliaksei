package com.epam.cinema.DAO;

import java.util.Set;

import com.epam.cinema.model.Booking;
import com.epam.cinema.model.Person;

public interface BookingDAO {

	Boolean setBooking(Long id, Person person);

	Boolean returnBooking(Long id);

	Booking getBookingById(Long id);

	Set<Booking> findBookings();

	Set<Booking> findBookedTickets();

}
