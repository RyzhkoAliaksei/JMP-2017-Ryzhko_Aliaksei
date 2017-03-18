package com.epam.mentoring.soap.client;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.epam.mentoring.soap.TicketService;
import com.epam.mentoring.soap.model.Person;
import com.epam.mentoring.soap.model.Ticket;

import java.net.URL;
import java.util.Arrays;

public class Client {

	public static void main(String[] args) throws Exception {

		URL wsdlUrl = new URL("http://localhost:8080/service/ticket?wsdl");
		QName qname = new QName("http://soap.mentoring.epam.com/", "TicketServiceImplService");
		Service service = Service.create(wsdlUrl, qname);
		TicketService ticketService = service.getPort(TicketService.class);

		Ticket ticket = new Ticket();
		Person person = new Person();
		person.setName("Alex");
		person.setSurname("Ryzhko");

		ticket.setId(1);
		ticket.setCityArrival("Grodno");
		ticket.setCityDeparture("Harkiv");
		ticket.setPerson(person);

		ticket.setState("booked");
		System.out.println("Ticket added " + ticketService.addTicket(ticket));

		Ticket returnedTicket = ticketService.getTicket(1);
		System.out.println("Ticket " + returnedTicket.getId() + " Person name " + returnedTicket.getPerson().getName()
				+ " State " + returnedTicket.getState());

		ticketService.updateTicket(1);
		Ticket updatedTicket = ticketService.getTicket(1);
		System.out.println("Ticket " + updatedTicket.getId() + " State " + updatedTicket.getState());

		ticketService.deleteTicket(1);
		System.out.println("Ticket removed " + ticketService.getTicket(1));

	}
}
