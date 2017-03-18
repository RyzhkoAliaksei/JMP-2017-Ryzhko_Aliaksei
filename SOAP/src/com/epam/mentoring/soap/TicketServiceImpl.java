package com.epam.mentoring.soap;

import java.util.HashMap;
import java.util.Map;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.epam.mentoring.soap.model.Ticket;

@WebService(endpointInterface="com.epam.mentoring.soap.TicketService")
public class TicketServiceImpl implements TicketService {

	private static Map<Integer, Ticket> tickets = new HashMap<Integer, Ticket>();

	@Override
	@WebMethod
	public boolean addTicket(Ticket ticket) {
		if (tickets.get(ticket.getId()) != null)
			return false;
		tickets.put(ticket.getId(), ticket);
		return true;
	}

	@Override
	@WebMethod
	public boolean deleteTicket(int id) {
		if (tickets.get(id) == null)
			return false;
		tickets.remove(id);
		return true;
	}

	@Override
	@WebMethod
	public Ticket getTicket(int id) {
		return tickets.get(id);
	}

	@Override
	@WebMethod
	public boolean updateTicket(int id) {
		if (tickets.get(id) == null)
			return false;
		Ticket ticket = tickets.get(id);
		ticket.setState("Paid");
		return true;
	}

}
