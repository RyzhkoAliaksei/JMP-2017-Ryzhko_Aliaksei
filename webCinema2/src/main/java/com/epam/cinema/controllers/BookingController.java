package com.epam.cinema.controllers;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.epam.cinema.model.Booking;
import com.epam.cinema.service.BookingService;

@Controller
@RequestMapping("bookings")
public class BookingController {
	private static final Logger LOG = Logger.getLogger(BookingController.class);
	@Autowired
	private BookingService bookingService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showAllFreeTickets(Model model) {
		model.addAttribute("bookings", bookingService.findBookings());
		return "bookings";
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView newBookingForm(Model model) {
		model.addAttribute("booking", new Booking());
		model.addAttribute("action", "new");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("bookings.form");
		return mav;
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String newBookingSubmit(@ModelAttribute Booking booking, Model model, HttpSession session) {
		String view = "bookings";
		bookingService.createBooking(booking);
		LOG.info("Add booking-" + booking.getFilmName());
		model.addAttribute("bookings", bookingService.findBookings());
		model.asMap().remove("booking");
		return view;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editBookingForm(@PathVariable("id") Booking booking, HttpSession session, Model model) {
		model.addAttribute("booking", booking);
		model.addAttribute("action", booking.getId());
		return "bookings.form";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public String editBookingSubmit(@ModelAttribute Booking booking, Model model, HttpSession session) {
		String view = "bookings";
		bookingService.editBooking(booking);
		model.addAttribute("bookings", bookingService.findBookings());
		LOG.info("Modify booking-" + booking.getId());
		model.asMap().remove("booking");
		return view;
	}

	@RequestMapping(value = "/bookingTicket/{id}", method = RequestMethod.GET)
	public String bookTicketForm(@PathVariable("id") Booking booking, HttpSession session, Model model) {
		model.addAttribute("booking", booking);
		model.addAttribute("action", booking.getId());
		return "book.ticket.form";
	}

	@RequestMapping(value = "/bookingTicket/{id}", method = RequestMethod.POST)
	public String bookTicketSubmit(@ModelAttribute Booking booking, Model model, HttpSession session) {
		String view = "bookings";
		bookingService.setBooking(booking.getId(), booking.getClient());
		model.addAttribute("bookings", bookingService.findBookings());
		LOG.info("Modify booking-" + booking.getId());
		model.asMap().remove("booking");
		return view;
	}

	@RequestMapping(value = "/bookedTickets", method = RequestMethod.GET)
	public String bookedTickets(Model model) {
		model.addAttribute("bookings", bookingService.findBookedTickets());
		return "booked.tickets";
	}

	@RequestMapping(value = "/returnTicket/{id}", method = RequestMethod.GET)
	public String returnTicket(@PathVariable("id") Booking booking, HttpSession session, Model model) {
		bookingService.returnBooking(booking.getId());
		model.addAttribute("bookings", bookingService.findBookedTickets());
		return "booked.tickets";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteBooking(@PathVariable("id") Booking booking, HttpSession session, Model model) {
		bookingService.removeBookingById(booking.getId());
		model.addAttribute("bookings", bookingService.findBookings());
		return "bookings";
	}

}
