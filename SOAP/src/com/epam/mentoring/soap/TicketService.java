package com.epam.mentoring.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.epam.mentoring.soap.model.Ticket;

@WebService
public interface TicketService {
	@WebMethod
	int bookTicket(Ticket ticket);

	@WebMethod
	boolean returnTicket(int id);

	@WebMethod
	Ticket getTicket(int id);

	@WebMethod
	boolean payTicket(int id);

}
