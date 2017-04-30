package com.epam.cinema.converters;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import com.epam.cinema.model.Booking;
import com.epam.cinema.service.BookingService;

@Component
public class BookingFormatter implements Formatter<Booking> {

	@Autowired
	private BookingService bookingService;

	@Override
	public Booking parse(String id, Locale locale) throws ParseException {
		Booking booking = bookingService.getBookingById(Long.parseLong(id));

		return booking;
	}

	public String print(Booking booking, Locale locale) {
		return booking.getId().toString();
	};
}
