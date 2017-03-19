/**
 * Ticket.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.epam.mentoring.soap.model;

import java.util.Date;

public class Ticket implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String cityArrival;

	private String cityDeparture;

	private Date dateArrival;

	private Date dateDeparture;

	private int id;
	
	private int price;

	private Person person;

	private State state;

	public String getCityArrival() {
		return cityArrival;
	}

	public void setCityArrival(java.lang.String cityArrival) {
		this.cityArrival = cityArrival;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCityDeparture() {
		return cityDeparture;
	}

	public void setCityDeparture(java.lang.String cityDeparture) {
		this.cityDeparture = cityDeparture;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Date getDateArrival() {
		return dateArrival;
	}

	public void setDateArrival(Date dateArrival) {
		this.dateArrival = dateArrival;
	}

	public Date getDateDeparture() {
		return dateDeparture;
	}

	public void setDateDeparture(Date dateDeparture) {
		this.dateDeparture = dateDeparture;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
