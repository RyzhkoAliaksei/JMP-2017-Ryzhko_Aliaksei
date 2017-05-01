package com.epam.cinema.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.epam.cinema.model.Booking;
import com.epam.cinema.service.BookingService;


@Component
public class StringToBookingConverter implements Converter<String, Booking> {
 
    @Autowired
	private BookingService bookingService;
    
    @Override
    public Booking convert(String id) {
       
    	return bookingService.getBookingById(new Long(id));
    }
 
}