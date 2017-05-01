package com.epam.cinema.service;

import com.epam.cinema.model.Person;

public interface PersonService {

	Long createPerson(Person person);

	void removePersonById(Long id);

	Person getPersonById(Long id);
}
