package com.epam.mentoring.soap.model;

public class Person implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String Name;
	private String Surname;
	private String Middlename;
	private int price;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getSurname() {
		return Surname;
	}
	public void setSurname(String surname) {
		Surname = surname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getMiddlename() {
		return Middlename;
	}
	public void setMiddlename(String middlename) {
		Middlename = middlename;
	}

}
