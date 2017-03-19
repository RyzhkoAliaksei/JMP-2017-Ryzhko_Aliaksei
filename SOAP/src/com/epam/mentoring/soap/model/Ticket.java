/**
 * Ticket.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.epam.mentoring.soap.model;

public class Ticket implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private java.lang.String cityArrival;

	private java.lang.String cityDeparture;

	private java.util.Calendar dateArrival;

	private java.util.Calendar dateDeparture;

	private int id;

	private Person person;

	private State state;

	public java.lang.String getCityArrival() {
		return cityArrival;
	}

	public void setCityArrival(java.lang.String cityArrival) {
		this.cityArrival = cityArrival;
	}

	public java.lang.String getCityDeparture() {
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

	public java.util.Calendar getDateArrival() {
		return dateArrival;
	}

	public void setDateArrival(java.util.Calendar dateArrival) {
		this.dateArrival = dateArrival;
	}

	public java.util.Calendar getDateDeparture() {
		return dateDeparture;
	}

	public void setDateDeparture(java.util.Calendar dateDeparture) {
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
