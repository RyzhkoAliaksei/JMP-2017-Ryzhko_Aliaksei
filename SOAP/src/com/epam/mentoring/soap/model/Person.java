package com.epam.mentoring.soap.model;

import java.util.Date;

public class Person implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String Name;
	private String Surname;
	private String Middlename;
	private Date Birthday;

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

	public String getMiddlename() {
		return Middlename;
	}

	public void setMiddlename(String middlename) {
		Middlename = middlename;
	}

	public Date getBirthday() {
		return Birthday;
	}

	public void setBirthday(Date birthday) {
		Birthday = birthday;
	}

}
