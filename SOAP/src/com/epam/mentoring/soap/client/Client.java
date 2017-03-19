package com.epam.mentoring.soap.client;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.epam.mentoring.soap.TicketService;
import com.epam.mentoring.soap.model.Person;
import com.epam.mentoring.soap.model.Ticket;

import java.net.URL;

public class Client {

	public static void main(String[] args) throws Exception {

		URL wsdlUrl = new URL("http://localhost:8080/service/ticket?wsdl");
		QName qname = new QName("http://soap.mentoring.epam.com/", "TicketServiceImplService");
		Service service = Service.create(wsdlUrl, qname);
		TicketService ticketService = service.getPort(TicketService.class);

		Ticket ticket = new Ticket();
		Person person = new Person();
		person.setName("Alex");
		person.setMiddlename("Alexandrovich");
		person.setSurname("Ryzhko");
		ticket.setPrice(5);
		ticket.setCityArrival("Grodno");
		ticket.setCityDeparture("Kharkiv");
		ticket.setPerson(person);
        int bookedTicketId=ticketService.bookTicket(ticket);
		System.out.println("Ticket added " + bookedTicketId);

		Ticket returnedTicket = ticketService.getTicket(bookedTicketId);
		System.out.println("Ticket " + returnedTicket.getId() + " Person name " + returnedTicket.getPerson().getName()
				+ " State " + returnedTicket.getState().toString());

		ticketService.payTicket(bookedTicketId);
		Ticket updatedTicket = ticketService.getTicket(bookedTicketId);
		System.out.println("Ticket " + updatedTicket.getId() + " State " + updatedTicket.getState().toString());

		ticketService.returnTicket(bookedTicketId);
		System.out.println("Ticket removed " + ticketService.getTicket(bookedTicketId));

	}
}
