package cinema.service;

import java.util.Date;
import java.util.Set;

import cinema.model.Booking;
import cinema.model.Person;

public interface BookingService {

	Long createBooking(Booking booking);

	Boolean setBooking(Long id, Person person,Date date);

	Boolean returnBooking(Long id);

	Booking getBookingById(Long id);

	void removeBookingById(Long id);

	Set<Booking> findBookingsByDate(Date date);

}
