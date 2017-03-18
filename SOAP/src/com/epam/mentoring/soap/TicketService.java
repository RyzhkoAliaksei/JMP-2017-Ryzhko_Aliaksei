package com.epam.mentoring.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.epam.mentoring.soap.model.Ticket;
@WebService
public interface TicketService {
	@WebMethod
	public boolean addTicket(Ticket ticket);
	@WebMethod
	public boolean deleteTicket(int id);
	@WebMethod
	public Ticket getTicket(int id);
	@WebMethod
	public boolean updateTicket(int id);

}
