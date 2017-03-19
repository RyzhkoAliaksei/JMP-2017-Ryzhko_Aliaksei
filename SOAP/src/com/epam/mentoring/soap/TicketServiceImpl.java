package com.epam.mentoring.soap;

import java.util.HashMap;
import java.util.Map;

import javax.jws.WebService;

import com.epam.mentoring.soap.model.State;
import com.epam.mentoring.soap.model.Ticket;

@WebService(endpointInterface = "com.epam.mentoring.soap.TicketService")
public class TicketServiceImpl implements TicketService {

	private static Map<Integer, Ticket> tickets = new HashMap<Integer, Ticket>();

	public int bookTicket(Ticket ticket) {
		if (tickets.isEmpty()) {
			ticket.setId(1);
		} else {
			ticket.setId(tickets.size() + 1);
		}
		ticket.setState(State.BOOKED);
		tickets.put(ticket.getId(), ticket);

		return ticket.getId();
	}

	public boolean returnTicket(int id) {
		if (tickets.get(id) == null)
			return false;
		tickets.remove(id);
		return true;
	}

	public Ticket getTicket(int id) {
		return tickets.get(id);
	}

	public boolean payTicket(int id) {
		if (tickets.get(id) == null)
			return false;
		Ticket ticket = tickets.get(id);
		ticket.setState(State.PAID);
		return true;
	}

}
