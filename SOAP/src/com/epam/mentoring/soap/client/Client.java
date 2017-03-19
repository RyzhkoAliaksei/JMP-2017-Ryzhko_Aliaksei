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
		person.setPrice(5);
		ticket.setCityArrival("Grodno");
		ticket.setCityDeparture("Kharkiv");
		ticket.setPerson(person);

		System.out.println("Ticket added " + ticketService.bookTicket(ticket));

		Ticket returnedTicket = ticketService.getTicket(1);
		System.out.println("Ticket " + returnedTicket.getId() + " Person name " + returnedTicket.getPerson().getName()
				+ " State " + returnedTicket.getState().toString());

		ticketService.payTicket(1);
		Ticket updatedTicket = ticketService.getTicket(1);
		System.out.println("Ticket " + updatedTicket.getId() + " State " + updatedTicket.getState().toString());

		ticketService.returnTicket(1);
		System.out.println("Ticket removed " + ticketService.getTicket(1));

	}
}
